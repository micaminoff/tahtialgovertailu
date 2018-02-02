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
import java.util.Stack;
import tahti.datastructure.Graph;
import tahti.datastructure.Vertex;
import tahti.datastructure.VertexComparator;

/**
 * A class implementing the A*-search algorithm
 * @author Michael Aminoff
 */
public class AStar {

    private Vertex[][] vertices;
    private Map<Vertex, Vertex> parents;
    private Map<Vertex, Integer> dist_from_source;
    private PriorityQueue<Vertex> open;
    private Graph g;

    public AStar(Graph g) {
        this.g = g;
        vertices = g.get_vertices();
    }

    
    /**
     * The main workhorse of the algorithm, goes through the graph and returns
     * a string containing the best path and the total length from source to
     * target
     * @param source the starting vertex
     * @param target the goal
     * @return a string containing the best path and total length from source
     * to goal
     */
    public String run(Vertex source, Vertex target) {
        if (source.get_cost() == -1) {
            // Sanity check, source cannot be impassable terrain
            return "Invalid starting position";
        }
        
        // Initialize datastructures
        parents = new HashMap<>();
        dist_from_source = new HashMap<>();
        open = new PriorityQueue<>(new VertexComparator());
        
        // Add the source to queue and set it's priority to 0
        open.add(source);
        dist_from_source.put(source, 0);
        System.out.println("Init done");
        
        
        // While we still have potential vertices to explore
        while (!open.isEmpty()) {
            // Select the queue item with lowest f (seemingly best vertex)
            Vertex current = open.poll();
            if (current == target) {
                // We've found the shortest path!
                return return_results(source, target);
            }
            for (Vertex v : g.get_vertices_neighbors(current)) {
                if (v.get_cost() == -1) {
                    // Skip this vertex if it's impassable
                    continue;
                }
                // Total cost from source to this neighbor
                int cost = dist_from_source.get(current) + v.get_cost();
                if (dist_from_source.containsKey(v) && cost > dist_from_source.get(v)) {
                    // If we already have the best path to this vertex, skip.
                    continue;
                } else {
                    // Update estimates, distances from source and path
                    dist_from_source.put(v, cost);
                    v.set_f(cost + make_estimate(v, target));
                    open.add(v);
                    parents.put(v, current);
                }
            }
        }
        return return_results(source, target);
    }

    /**
     * Creates the h(n) of A*
     * @param source from where
     * @param target to where
     * @return h(n) as manhattan distance
     */
    private int make_estimate(Vertex source, Vertex target) {
        return (Math.abs(source.get_col() - target.get_col())
                + Math.abs(source.get_row() + target.get_row()));
    }

    /**
     * Strips datastructures to the info that concerns us
     * @param source from where
     * @param target to where
     * @return A string containing the path and total distance
     */
    private String return_results(Vertex source, Vertex target) {
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
