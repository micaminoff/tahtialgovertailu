/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.algorithm;

import java.util.PriorityQueue;
import tahti.datastructure.*;
import tahti.datastructure.VertexComparator;

/**
 * A class implementing Dijkstra's pathfinding algorithm
 * @author Michael Aminoff
 */
public class Dijkstra implements SearchAlgorithm {

    private Vertex[][] vertices;
    private VertexMap parents;
    private PriorityQueue<Vertex> white;
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
        if (source.get_cost() == Integer.MAX_VALUE) {
            // Sanity check
            return;
        }
        // Init datastructures
        this.target = target;
        parents = new VertexMap();
        white = new PriorityQueue<>(new VertexComparator());
        init_single_source(source);

        try {
            while (!white.isEmpty()) {  // While we haven't explored all nodes
                Vertex current = white.poll();
                if (current == null || current == target) {
                    return;
                }
                if (current.get_cost() == Integer.MAX_VALUE) {
                    white.remove(current);
                    continue;
                }
                white.remove(current);
                for (Vertex n : g.get_vertices_neighbors(current)) {
                    // Iterate through neighbors and update distances
                    int path_weight = current.get_f();
                    if (n.get_cost() == Integer.MAX_VALUE) {
                        white.remove(n);
                        continue;
                    }
                    path_weight += n.get_cost();
                    if (path_weight < n.get_f()) {
                        // We found a better path! Update maps!
                        n.set_f(path_weight);
                        white.add(n);
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
                if (current != source) {
                    current.set_f(Integer.MAX_VALUE);
                }
            }
        }
        source.set_f(0);
        white.add(source);
        parents.put(source, null);
    }


    public int get_path_length() {
        Vertex current = (Vertex) parents.get(target);
        int i = 0;
        while (current != null) {
            i++;
            current = (Vertex) parents.get(current);
        }
        return i;
    }

    public String get_path() {
        Vertex current = (Vertex) parents.get(target);
        String path = ""+current;
        while (current != null) {
            path += " - " + current;
            current = (Vertex) parents.get(current);
        }
        return path;
    }

    public int get_vertex_count() {
        return parents.get_size();
    }
}
