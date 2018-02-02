/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import tahti.datastructure.Graph;
import tahti.datastructure.Vertex;
import tahti.datastructure.VertexComparator;

/**
 *
 * @author Michael Aminoff
 */
public class AStar {

    private Vertex[][] vertices;
    private Map<Vertex, Vertex> parents;
    private Map<Vertex, Integer> dist_from_source;
    private PriorityQueue<Vertex> open;
    private Set<Vertex> closed;
    private Graph g;

    public AStar(Graph g) {
        this.g = g;
        vertices = g.get_vertices();
    }

    public String run(Vertex source, Vertex target) {
        if (source.get_cost() == -1) {
            return "Invalid starting position";
        }
        parents = new HashMap<>();
        dist_from_source = new HashMap<>();
        open = new PriorityQueue<>(new VertexComparator());
        closed = new HashSet<>();
        open.add(source);
        dist_from_source.put(source, 0);
        System.out.println("Init done");
        while (!open.isEmpty()) {
            Vertex current = open.poll();
            if (current == target) {
                return return_results(source, target);
            }
            for (Vertex v : g.get_vertices_neighbors(current)) {
                if (v.get_cost() == -1) {
                    continue;
                }
                int cost = dist_from_source.get(current) + v.get_cost();
                if (!dist_from_source.containsKey(v)) {
                    dist_from_source.put(v, cost);
                    v.set_f(cost + make_estimate(v, target));
                    open.add(v);
                    parents.put(v, current);
                } else if (cost < dist_from_source.get(v)) {
                    dist_from_source.put(v, cost);
                    v.set_f(cost + make_estimate(v, target));
                    open.add(v);
                    parents.put(v, current);
                }
            }
        }
        return return_results(source, target);
    }

    private int make_estimate(Vertex source, Vertex target) {
        return (Math.abs(source.get_col() - target.get_col())
                + Math.abs(source.get_row() + target.get_row()));
    }

    private String return_results(Vertex source, Vertex target) {
        Iterator it = dist_from_source.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if ((int) entry.getValue() == 2147483647) {
                it.remove();
            }
        }
        Iterator it2 = parents.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            if (entry2.getValue() == null) {
                it2.remove();
            }
        }
        Stack<Vertex> path = new Stack<>();
        Vertex current = target;
        while (current != source) {
            path.push(current);
            current = parents.get(current);
        }
        String walk = "Path: " + source;
        while (!path.empty()) {
            walk += " - " + path.pop();
        }
        return walk + "\nTotal length: " + dist_from_source.get(target);
    }

}
