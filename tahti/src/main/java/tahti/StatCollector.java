/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;

import tahti.algorithm.AStar;
import tahti.algorithm.Dijkstra;
import tahti.algorithm.SearchAlgorithm;
import tahti.datastructure.Graph;
import tahti.datastructure.Vertex;

/**
 *
 * @author Michael Aminoff
 */
public class StatCollector {
    
    public void routine_1() {
        Graph g = new Graph("./src/resources/brc100d.map");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(149, 234);
        int reps = 10;
        SearchAlgorithm[] algos = new SearchAlgorithm[1];
        algos[0] = new AStar(g);
        run_routine(g, source, target, reps, algos);
    }
    
    public void routine_2() {
        Graph g = new Graph("./src/resources/brc100d.map");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(149, 234);
        int reps = 2;
        SearchAlgorithm[] algos = new SearchAlgorithm[1];
        algos[0] = new Dijkstra(g);
        run_routine(g, source, target, reps, algos);
    }
    
    private void run_routine(Graph g, Vertex source, Vertex target, int reps, SearchAlgorithm[] algos) {
        for (SearchAlgorithm a : algos) {
            long [] times = new long[reps];
            for (int i = 0; i < reps; i++) {
                long start_time = System.currentTimeMillis();
                a.run(target, source);
                times[i] = System.currentTimeMillis() - start_time;
                g.reset_graph();
            }
            int cols = g.get_n_columns();
            int rows = g.get_n_rows();
            String name = a.getClass().getSimpleName();
            int path_length = a.get_path_length();
            int opened_vertices = a.get_vertex_count();
            print_results(name, cols, rows, path_length, opened_vertices, times);
        }
    }
    
    private void print_results(String name, int cols, int rows, int path_length, int opened_vertices, long[] times) {
        System.out.println("Performance of " + name + " on a " + cols + "x" + rows + " map:");
        System.out.println("Shortest path: " + path_length + " steps.");
        System.out.println("Opened vertices: " + opened_vertices);
        System.out.println("Average running time: " + get_average_time(times) + "ms");
        System.out.println("\n\n");
    }

    private String get_average_time(long[] times) {
        long total_time = 0;
        for (long t : times) {
            total_time += t;
        }
        return ""+ total_time/times.length;
    }
}
