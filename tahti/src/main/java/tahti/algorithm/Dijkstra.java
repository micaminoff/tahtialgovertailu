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
import java.util.List;
import java.util.Map;
import java.util.Set;
import tahti.datastructure.*;

/**
 *
 * @author Michael Aminoff
 */
public class Dijkstra {

    private List<Vertex> vertices;
    private List<Edge> edges;
    private Map<Vertex, Vertex> parents;
    private Map<Vertex, Integer> dist_from_source;
    private Set<Vertex> black;
    private Set<Vertex> white;

    /**
     * Creates a Dijkstra algorithm instance
     *
     * @param g A Graph consisting of Edges and Vertices
     */
    public Dijkstra(Graph g) {
        this.vertices = new ArrayList<>(g.get_vertices());
        this.edges = new ArrayList<>(g.get_edges());
    }

    /**
     * Runs Dijkstra's algorithm
     * Pseudocode from CLRS, Kivinen, and gitta.info
     * @param source the starting Vertex
     * @return A map of metric_name: value, for now only path Map
     */
    public Map run(Vertex source) {
        Map<String, Map> results = new HashMap<>();
        // Init
        dist_from_source = new HashMap<Vertex, Integer>();
        parents = new HashMap<Vertex, Vertex>();
        black = new HashSet<>();
        white = new HashSet<>();
        for (Vertex v : vertices) {
            dist_from_source.put(v, Integer.MAX_VALUE);
            if (v != source) {
                parents.put(v, null);
            }
            white.add(v);
        }
        dist_from_source.put(source, 0);

        try {
            while (!white.isEmpty()) {
                Vertex current = select_smallest_distance();
                white.remove(current);
                for (Vertex n : current.get_neighbors()) {
                    int path_weight = dist_from_source.get(current);
                    path_weight += dist_between(current, n);
                    if (path_weight < dist_from_source.get(n)) {
                        dist_from_source.put(n, path_weight);
                        parents.put(n, current);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        results.put("Parents", parents);
        results.put("Weights", dist_from_source);
        return results;
    }

    private Vertex select_smallest_distance() throws Exception {
        Vertex smallest = null;
        int smallest_distance = Integer.MAX_VALUE;
        for (Vertex v : white) {
            int current_dist = dist_from_source.get(v);
            if (current_dist < smallest_distance) {
                smallest = v;
                smallest_distance = current_dist;
            }
        }
        if (smallest == null) {
            throw new Exception("No smallest found");
        }
        return smallest;
    }
    
    private int dist_between(Vertex source, Vertex target) throws Exception {
        for (Edge e : edges) {
            if (e.get_source().equals(source) && e.get_dest().equals(target)) {
                return e.get_w();
            }
        }
        throw new Exception("No edge found.");
    }

}
