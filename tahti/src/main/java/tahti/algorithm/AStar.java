/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.algorithm;

import tahti.datastructure.*;

/**
 * A class implementing the A*-search algorithm
 *
 * @author Michael Aminoff
 */
public class AStar implements SearchAlgorithm {

    private VertexMap parents;
    private VertexMap dist_from_source;
    private PriorityQ open;
    private final Graph g;
    private Vertex target;
    private int visited;
    private int max_q_size;

    public AStar(Graph g) {
        this.g = g;
    }

    /**
     * The main workhorse of the algorithm, this method initially only knows about the start and
     * goal and their relative positions on a map which is implemented as a 2d Vertex array.
     *
     * We start by calculating the manhattan distance from the starting node to the goal. Then do
     * the same for its neighbors. We then compare all neighbors and select the node that minimizes:
     * ditance traveled so far + estimated distance
     *
     * We then add the originating node as the new node's parent, thus creating a path.
     *
     * @param source the starting vertex
     * @param target the goal
     */
    @Override
    public void run(Vertex source, Vertex target) {
        // Initialize datastructures and metrics
        this.visited = 0;
        this.target = target;
        this.max_q_size = 0;
        parents = new VertexMap<>();
        dist_from_source = new VertexMap<>();
        open = new PriorityQ();

        if (source.get_cost() == Integer.MAX_VALUE) {
            // Sanity check, source cannot be impassable terrain
            parents.put(target, null);
            return;
        }

        // Add the source to queue and set its priority to 0
        open.add(source);
        dist_from_source.put(source, 0);
        parents.put(source, null);

        // While we still have potential vertices to explore
        while (!open.is_empty()) {
            // Select the queue item with lowest f (vertex seemingly closest to goal)
            Vertex current = open.poll();
            if (current.get_cost() == Integer.MAX_VALUE) {
                continue;
            }
            if (current == target) {
                // We've found the shortest path!
                return;
            }
            for (Vertex v : g.get_vertices_neighbors(current)) {
                if (open.get_populated() > max_q_size) {max_q_size = open.get_populated();}
                // Total cost from source to this neighbor
                if (v == null) {
                    continue;
                }
                visited++;
                if (v.get_cost() == Integer.MAX_VALUE) {
                    continue;
                }
                int cost = (int) dist_from_source.get(current) + v.get_cost();
                if (!dist_from_source.containsKey(v) || cost < (int) dist_from_source.get(v)) {
                    dist_from_source.put(v, cost);
                    v.set_f(cost + make_estimate(v, target));
                    open.add(v);
                    parents.put(v, current);
                }
            }
        }
    }

    /**
     * Creates the h(n) of A*, that is: creates the heuritsic by calculating the manhattan distance
     * between two points in a coordinate system.
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
        return parents.get_size();
    }

}
