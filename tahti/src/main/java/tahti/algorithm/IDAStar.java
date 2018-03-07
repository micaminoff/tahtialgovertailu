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
    private int visited;
    private VertexStack path;
    private int max_opened;
    private int currently_opened;

    public IDAStar(Graph g) {
        this.g = g;
    }

    /**
     * IDA* is a memory-constrained Iterative Deepening implementation of A* It makes an optimistic
     * guess of how far away the target is from the start and doesn't allow for exploration beyond
     * that point. IDA* is a recursive DFS, selecting the best f-value among the last vertex's
     * neighbors for the next recursion. If a vertex's f-score exceeds the threshold we return from
     * recursion and select the lowest of the exceeding f-values as the next threshold. Then we
     * forget everything we learned and do it again.
     *
     * @param start The vertex we start from
     * @param target The vertex we want to get to
     */
    @Override
    public void run(Vertex start, Vertex target) {
        // Init datastructures and metrics
        this.visited = 0;
        this.max_opened = 0;
        this.currently_opened = 0;
        this.parents = new VertexMap<>();
        this.target = target;
        this.path = new VertexStack();
        path.push(start);
        // Initial threshold = h(start => target)
        int threshold = make_estimate(start, target);
        if (target.get_cost() == Integer.MAX_VALUE) {
            parents.put(target, null);
            return;
        }
        
        while (true) {
            // Initial call, always search from start with cumulative cost=0
            Vertex temp = search(start, 0, threshold);
            if (temp == null || temp == target || temp.get_f() == Integer.MAX_VALUE) {
                if (temp == null || temp.get_f() == Integer.MAX_VALUE) {
                    parents.put(target, null);
                }
                // Break loop if target found or unfindable
                return;
            }
            threshold = temp.get_f();
        }
    }

    /**
     * The recursive function. Figures out if we've found the target or exceeded the threshold by
     * recursively and greedily going through v's neighbors
     *
     * @param v The vertex currently under consideration
     * @param dist_from_source the cost to get to v from start
     * @param threshold the threshold, stop recursing if we exceed this
     * @return Target or lowest f vertex
     */
    private Vertex search(Vertex v, int dist_from_source, int threshold) {
        visited++;

        int f;
        // If current node is impassable or we caused an overflow
        if (v.get_cost() == Integer.MAX_VALUE || dist_from_source < 0) {
            f = Integer.MAX_VALUE;
        } else {
            f = dist_from_source + make_estimate(v, target);
        }
        v.set_f(f);

        // Return target or a vertex whose f exceeds the threshold
        if (v == target || v.get_f() > threshold) {
            return v;
        }

        int min = Integer.MAX_VALUE;
        Vertex min_vertex = null;
        PriorityQ neighbors = get_ordered_neighbors(v);
        currently_opened += neighbors.get_populated();
        if (currently_opened > max_opened) { max_opened = currently_opened; }

        // Iterate through v's neighbors
        while (!neighbors.is_empty()) {
            // Select most promising vertex that hasn't been visited in the current path
            Vertex n = neighbors.poll();
            currently_opened--;
            if (path.contains(n)) {
                continue;
            }
            path.push(n);
            // Recurse, using the most promising of v's neighbors
            Vertex temp = search(n, dist_from_source + n.get_cost(), threshold);
            if (temp == target) {
                // Score! Log this path.
                //System.out.println("N: " + n + ", V: " + v + ", temp: " + temp);
                parents.put(n, v);
                return target;
            }
            // Helper conditional to get the smallest of the exceeding vertices
            if (temp.get_f() <= min) {
                min = temp.get_f();
                min_vertex = temp;
            }
            path.pop();
        }
        currently_opened = 0;
        if (min_vertex == null) {
            min_vertex = new Vertex(-1, -1);
            min_vertex.set_f(threshold+1);
        }
        return min_vertex;
    }

    /**
     * Method for finding and sorting a vertex's neighbors according to their f-value
     *
     * @param v the vertex whose neighbors we want
     * @return a PriorityQ of vertices
     */
    private PriorityQ get_ordered_neighbors(Vertex v) {
        Vertex[] neighbors = g.get_vertices_neighbors(v);
        PriorityQ ordered_neighbors = new PriorityQ();
        for (Vertex n : neighbors) {
            if (n == null) {
                continue;
            }
            int f;
            if (n.get_cost() == Integer.MAX_VALUE) {
                f = Integer.MAX_VALUE;
            } else {
                f = make_estimate(n, target);
            }
            n.set_f(f);
            ordered_neighbors.add(n);
        }
        return ordered_neighbors;
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
        String p = "" + current;
        while (current != null) {
            p += " - " + current;
            current = (Vertex) parents.get(current);
        }
        return p;
    }

    @Override
    public int get_vertex_count() {
        return visited;
    }

    @Override
    public int get_max_open() {
        return parents.get_size();
    }

}