/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.algorithm;

import tahti.datastructure.*;

/**
 * A class implementing Dijkstra's pathfinding algorithm
 *
 * @author Michael Aminoff
 */
public class Dijkstra implements SearchAlgorithm {

    private VertexMap parents;
    private PriorityQ white;
    private final Graph g;
    private Vertex target;
    private int visited;
    private int max_opened;

    /**
     * Creates a Dijkstra algorithm instance
     *
     * @param g A Graph consisting of Edges and Vertices
     */
    public Dijkstra(Graph g) {
        this.g = g;
    }

    /**
     * Runs Dijkstra's algorithm.
     *
     * @param source the starting Vertex
     * @param target the target v
     */
    @Override
    public void run(Vertex source, Vertex target) {
        // Init datastructures and metrics
        this.visited = 0;
        this.target = target;
        this.max_opened = 0;
        parents = new VertexMap<>();
        white = new PriorityQ();

        if (source.get_cost() == Integer.MAX_VALUE) {
            parents.put(target, null);
            return;
        }

        init_single_source(source);

        while (!white.is_empty()) {  // While we haven't explored all nodes
            Vertex current = white.poll();
            max_opened--;
            if (current == null || current == target) {
                return;
            }
            if (current.get_cost() == Integer.MAX_VALUE) {
                continue;
            }
            for (Vertex n : g.get_vertices_neighbors(current)) {
                if (n == null) {
                    continue;
                }
                visited++;
                // Iterate through neighbors and update distances
                int path_weight = current.get_f();

                path_weight += n.get_cost();
                if (path_weight < n.get_f()) {
                    // We found a better path! Update maps!
                    n.set_f(path_weight);
                    white.add(n);
                    if (white.get_populated() > max_opened){max_opened = white.get_populated();}
                    parents.put(n, current);
                }
            }
        }
    }

    /**
     * Classic Dijkstra init. Sets all distances to max, adds all verteces to white, and sets source
     * distance to 0
     *
     * @param source the starting vetrex
     */
    private void init_single_source(Vertex source) {
        for (int i = 0; i < g.get_n_columns(); i++) {
            for (int j = 0; j < g.get_n_rows(); j++) {
                Vertex current = g.get_vertex_at(i, j);
                if (current != source) {
                    current.set_f(Integer.MAX_VALUE);
                }
            }
        }
        source.set_f(0);
        white.add(source);
        parents.put(source, null);
    }

    @Override
    public int get_path_length() {
        if (parents.get(target) == null) {
            return -1;
        }
        Vertex current = (Vertex) parents.get(target);
        int i = 0;
        while (current != null) {
            i++;
            current = (Vertex) parents.get(current);
        }
        return i;
    }

    @Override
    public String get_path() {
        Vertex current = (Vertex) parents.get(target);
        if (current == null) {
            return "No path available";
        }
        String path = ""+current;
        while (current != null) {
            path += " - " + current;
            current = (Vertex) parents.get(current);
        }
        return path;
    }

    @Override
    public int get_vertex_count() {
        return visited;
    }

    @Override
    public int get_path_weight() {
        Vertex current = (Vertex) parents.get(target);
        if (current == null) {
            return -1;
        }
        int weight = 0;
        while (current != null) {
            weight += current.get_cost();
            current = (Vertex) parents.get(current);
        }
        return weight;
    }

    @Override
    public int get_max_open() {
        return parents.get_size() + max_opened;
    }

}
