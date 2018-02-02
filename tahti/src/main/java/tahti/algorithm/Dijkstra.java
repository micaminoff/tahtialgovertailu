/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.algorithm;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import tahti.datastructure.*;

/**
 *
 * @author Michael Aminoff
 */
public class Dijkstra {

    private Vertex[] vertices;
    private List<Edge> edges;
    private Map<Vertex, Vertex> parents;
    private Map<Vertex, Integer> dist_from_source;
    private Set<Vertex> white;

    /**
     * Creates a Dijkstra algorithm instance
     *
     * @param g A Graph consisting of Edges and Vertices
     */
    public Dijkstra(Graph g) {
        this.vertices = g.get_vertices();
        this.edges = new ArrayList<>(g.get_edges());
    }

    /**
     * Runs Dijkstra's algorithm Pseudocode from CLRS, Kivinen, and gitta.info
     *
     * @param source the starting Vertex
     * @return A map of metric_name: value, for now only path Map
     */
    public String run(Vertex source, Vertex target) {
        dist_from_source = new HashMap<Vertex, Integer>();
        parents = new HashMap<Vertex, Vertex>();
        white = new HashSet<>();
        System.out.println("init done");

        // Classic Dijkstra init: set distance to infinity and add all nodes
        // to the set of unfinished nodes
        for (Vertex v : vertices) {
            dist_from_source.put(v, Integer.MAX_VALUE);
            if (v != source) {
                parents.put(v, null);
            }
            white.add(v);
        }
        dist_from_source.put(source, 0);

        try {
            while (!white.isEmpty()) {  // While we haven't explored all nodes
                Vertex current = select_closest_neighbor();
                if (current == null || current == target) {
                    return return_results(source, target);
                }
                white.remove(current);
                for (Vertex n : current.get_neighbors()) {
                    int path_weight = dist_from_source.get(current);
                    path_weight += dist_between(current, n);
                    if (path_weight < dist_from_source.get(n)) {
                        // We found a better path! Update maps!
                        dist_from_source.put(n, path_weight);
                        parents.put(n, current);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return return_results(source, target);
    }

    private Vertex select_closest_neighbor() throws Exception {
        Vertex smallest = null;
        int smallest_distance = Integer.MAX_VALUE;
        for (Vertex v : white) {
            int current_dist = dist_from_source.get(v);
            if (current_dist < smallest_distance) {
                smallest = v;
                smallest_distance = current_dist;
            }
        }
        return smallest;
    }

    private int dist_between(Vertex source, Vertex target) throws Exception {
        // Find the correct edge and return its weight.
        for (Edge e : edges) {
            if (e.get_source().equals(source) && e.get_dest().equals(target)) {
                return e.get_w();
            }
        }
        throw new Exception("No edge found.");
    }

    private String return_results(Vertex source, Vertex target) {
        HashMap<String, Map> results = new HashMap<>();
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
