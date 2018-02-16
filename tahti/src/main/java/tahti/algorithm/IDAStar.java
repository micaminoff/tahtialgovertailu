/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.algorithm;

import java.util.Stack;
import tahti.datastructure.*;

/**
 *
 * @author Michael Aminoff
 */
public class IDAStar implements SearchAlgorithm {

    private VertexMap parents;
    private Vertex target;
    private Graph g;
    private long max_used_memory;
    private Runtime rt;
    private Stack black;

    public IDAStar(Graph g) {
        this.g = g;
        this.parents = new VertexMap();
        this.max_used_memory = 0;
        this.rt = Runtime.getRuntime();
        this.black = new Stack();
    }

    @Override
    public void run(Vertex source, Vertex target) {
        // Sanity check
        black.push(source);
        if (source.get_cost() == Integer.MAX_VALUE || target.get_cost() == Integer.MAX_VALUE) {
            parents.put(target, null);
            return;
        }
        this.target = target;
        int threshold = make_estimate(source, target);
        while (true) {
            System.out.println(threshold);
            Vertex current = search(source, 0, threshold);
            if (current == target) {
                return;
            }
            threshold = current.get_f();
        }
    }

    public Vertex search(Vertex v, int cost, int threshold) {
        if (v == target) {
            System.out.println("WOOP");
            return v;
        }
        int f;
        if (v.get_cost() == Integer.MAX_VALUE || cost < 0) {
            f = Integer.MAX_VALUE;
        } else {
            f = cost + make_estimate(v, target);
        }
        v.set_f(f);
        if (f > threshold) {
            return v;
        }
        int min = Integer.MAX_VALUE;
        Vertex min_vertex = null;

        for (Vertex n : g.get_vertices_neighbors(v)) {
            if (n == null) {
                continue;
            }
            if (!black.contains(n)) {
                black.push(n);
                Vertex temp = search(n, cost + n.get_cost(), threshold);

                if (temp == target) {
                    System.out.println("V: " + v + ", n: " + n + ", temp: " + temp);
                    parents.put(temp, n);
                    return target;
                }
                if (temp.get_f() < min) {
                    min = temp.get_f();
                    min_vertex = temp;
                }
                black.pop();
            }

        }
        if (min == Integer.MAX_VALUE) {
            v.set_f(Integer.MAX_VALUE);
        }
        return min_vertex;

    }

    /**
     * Creates the h(n) of IDA*, that is: creates the heuritsic by calculating the manhattan
     * distance between two points in a coordinate system.
     *
     * @param source from where
     * @param target to where
     * @return h(n) as manhattan distance
     */
    private int make_estimate(Vertex source, Vertex target) {
        return (Math.abs(source.get_col() - target.get_col())
                + Math.abs(source.get_row() - target.get_row()));
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
    public String get_path() {
        Vertex current = (Vertex) parents.get(target);
        if (current == null) {
            return "No path available";
        }
        String path = "" + current;
        while (current != null) {
            path += " - " + current;
            current = (Vertex) parents.get(current);
        }
        return path;
    }

    @Override
    public int get_vertex_count() {
        return parents.get_size();
    }

    public long get_used_mem() {
        return max_used_memory;
    }

}
