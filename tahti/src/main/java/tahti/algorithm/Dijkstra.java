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
import java.util.Set;
import java.util.Stack;
import tahti.datastructure.*;

/**
 * A class implementing Dijkstra's pathfinding algorithm
 * @author Michael Aminoff
 */
public class Dijkstra implements SearchAlgorithm {

    private Vertex[][] vertices;
    private Map<Vertex, Vertex> parents;
    private Map<Vertex, Integer> dist_from_source;
    private Set<Vertex> white;
    private Graph g;
    private Vertex target;

    /**
     * Creates a Dijkstra algorithm instance
     *
     * @param g A Graph consisting of Edges and Vertices
     */
    public Dijkstra(Graph g) {
        this.vertices = g.get_vertices();
        this.g = g;
    }

    /**
     * Runs Dijkstra's algorithm.
     * @param source the starting Vertex
     */
    public void run(Vertex source, Vertex target) {
        if (source.get_cost() == -1) {
            // Sanity check
            return;
        }
        // Init datastructures
        this.target = target;
        dist_from_source = new HashMap<Vertex, Integer>();
        parents = new HashMap<Vertex, Vertex>();
        white = new HashSet<>();
        init_single_source(source);

        try {
            while (!white.isEmpty()) {  // While we haven't explored all nodes
                Vertex current = select_closest_neighbor();
                if (current == null || current == target) {
                    return;
                }
                white.remove(current);
                for (Vertex n : g.get_vertices_neighbors(current)) {
                    // Iterate through neighbors and update distances
                    int path_weight = dist_from_source.get(current);
                    if (dist_to(n) == -1) {
                        white.remove(n);
                        continue;
                    }
                    path_weight += dist_to(n);
                    if (path_weight < dist_from_source.get(n)) {
                        // We found a better path! Update maps!
                        dist_from_source.put(n, path_weight);
                        parents.put(n, current);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * Classic Dijkstra init. Sets all distances to max, adds all verteces to
     * white, and sets source distance to 0
     * @param source the starting vetrex
     */
    private void init_single_source(Vertex source) {
        for (int i = 0; i < g.get_n_columns(); i++) {
            for (int j = 0; j < g.get_n_rows(); j++) {
                Vertex current = vertices[i][j];
                dist_from_source.put(current, Integer.MAX_VALUE);
                white.add(current);
            }
        }
        dist_from_source.put(source, 0);
    }

    /**
     * Finds the vertex in white closest to source
     * @return the closest vertex
     * @throws Exception 
     */
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

    /**
     * Gets the cost to move to the given vertex
     * @param target the vertex to move to
     * @return the distance to said vertex
     */
    private int dist_to(Vertex target) {
        return target.get_cost();
    }

    public int get_path_length() {
        Vertex current = parents.get(target);
        int i = 0;
        while (current != null) {
            i++;
            current = parents.get(current);
        }
        return i;
    }

    public String get_path() {
        Vertex current = parents.get(target);
        String path = ""+current;
        while (current != null) {
            path += " - " + current;
            current = parents.get(current);
        }
        return path;
    }

    public int get_vertex_count() {
        return parents.size();
    }
}
