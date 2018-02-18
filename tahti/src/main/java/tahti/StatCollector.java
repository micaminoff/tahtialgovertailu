/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;

import tahti.algorithm.AStar;
import tahti.algorithm.Dijkstra;
import tahti.algorithm.IDAStar;
import tahti.algorithm.SearchAlgorithm;
import tahti.datastructure.Graph;
import tahti.datastructure.Vertex;

/**
 * A class for running predifined graph searches
 *
 * @author Michael Aminoff
 */
public class StatCollector {

    public void routine_1() {
        String description = "Routine 1: Runs A* 100 times on a 512x492 semi-open map, the correct path is 144 steps, w=144";
        Graph g = new Graph("./src/resources/brc100d.map");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(149, 234);
        int reps = 100;
        SearchAlgorithm[] algos = new SearchAlgorithm[1];
        algos[0] = new AStar(g);
        run_routine(description, g, source, target, reps, algos);
    }

    public void routine_2() {
        String description = "Routine 2: Runs Dijkstra 100 times on a 512x492 semi-open map, the correct path is 144 steps, w=144";
        Graph g = new Graph("./src/resources/brc100d.map");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(149, 234);
        int reps = 100;
        SearchAlgorithm[] algos = new SearchAlgorithm[1];
        algos[0] = new Dijkstra(g);
        run_routine(description, g, source, target, reps, algos);
    }

    public void routine_3() {
        String description = "Routine 3: Runs Dijkstra and AStar 50 times on a 512x492 semi-open map, the correct path is 496 steps with w=496";
        Graph g = new Graph("./src/resources/brc100d.map");
        Vertex source = g.get_vertex_at(130, 350);
        Vertex target = g.get_vertex_at(270, 172);
        int reps = 50;
        SearchAlgorithm[] algos = new SearchAlgorithm[2];
        algos[0] = new AStar(g);
        algos[1] = new Dijkstra(g);
        run_routine(description, g, source, target, reps, algos);
    }

    public void routine_4() {
        String description = "Routine 4: Runs Dijkstra and AStar 5 times on a 512x512 mazelike map. Correct path length is 5164";
        Graph g = new Graph("./src/resources/maze512-1-0.map");
        Vertex source = g.get_vertex_at(1, 5);
        Vertex target = g.get_vertex_at(511, 511);
        int reps = 5;
        SearchAlgorithm[] algos = new SearchAlgorithm[2];
        algos[0] = new AStar(g);
        algos[1] = new Dijkstra(g);
        run_routine(description, g, source, target, reps, algos);
    }


    public void routine_5() {
        String description = "Routine 5: IDA* and A* on a 512x512 mazelike map. Correct path is 8";
        Graph g = new Graph("./src/resources/maze512-1-0.map");
        Vertex source = g.get_vertex_at(1, 1);
        Vertex target = g.get_vertex_at(1, 5);
        int reps = 1;
        SearchAlgorithm[] algos = new SearchAlgorithm[2];
        algos[0] = new AStar(g);
        algos[1] = new IDAStar(g);
        run_routine(description, g, source, target, reps, algos);
    }
    
    public void routine_6() {
        String description = "Routine 6: IDA* and A* 10 times on a 512x512 mazelike map. Correct path is 34";
        Graph g = new Graph("./src/resources/maze512-1-0.map");
        Vertex source = g.get_vertex_at(1, 1);
        Vertex target = g.get_vertex_at(1, 15);
        int reps = 10;
        SearchAlgorithm[] algos = new SearchAlgorithm[2];
        algos[0] = new AStar(g);
        algos[1] = new IDAStar(g);
        run_routine(description, g, source, target, reps, algos);
    }
    
    /**
     * Seems to be too heavy for IDA*
     */
    public void routine_7() {
        String description = "Routine 1: Runs A* 5 times on a 512x492 semi-open map, the correct path is 144 steps, w=144";
        Graph g = new Graph("./src/resources/brc100d.map");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(110, 230);
        int reps = 5;
        SearchAlgorithm[] algos = new SearchAlgorithm[1];
        algos[0] = new IDAStar(g);
        run_routine(description, g, source, target, reps, algos);
    }

    /**
     * The method that actually runs the routines
     *
     * @param g The Graph
     * @param source The source
     * @param target The target
     * @param reps Amount of repetitions, higher values increase accuracy
     * @param algos The algorithms to run with the given parameters
     */
    private void run_routine(String description, Graph g, Vertex source, Vertex target, int reps, SearchAlgorithm[] algos) {
        System.out.println(description);
        System.out.format("%12s%10s%10s%17s", "Algorithm", "Time", "Memory", "Vertices opened");
        System.out.println("");
        for (SearchAlgorithm a : algos) {
            // For each algorithm in this routine
            long[] times = new long[reps];
            long[] mems = new long[reps];
            for (int i = 0; i < reps; i++) {
                // Repeat this many times
                long start_time = System.currentTimeMillis();
                a.run(source, target);
                times[i] = System.currentTimeMillis() - start_time;
                mems[i] = a.get_used_mem();
                // Reset the graph to nullify f-values
                g.reset_graph();
            }

            // Print the result
            String name = a.getClass().getSimpleName();
            int opened_vertices = a.get_vertex_count();
            System.out.println("");
            print_results(name, opened_vertices, times, mems);
        }
        System.out.println("\n");
    }

    /**
     * Helper method for printing results
     *
     * @param name name of the algorithm used
     * @param cols x-size of graph
     * @param rows y-size of graph
     * @param path_length the length of the correct path
     * @param opened_vertices the amount of examined vertices
     * @param times an array containing all recorded times for each rep
     */
    private void print_results(String name, long opened_vertices, long[] times, long[] mems) {
        String time = get_average_time(times);
        String mem = get_average_memory(mems);
        System.out.format("%12s%10s%10s%17s", name, time, mem, opened_vertices);
    }

    /**
     * Helper method for averaging times
     *
     * @param times the recorded times
     * @return an average
     */
    private String get_average_time(long[] times) {
        long total_time = 0;
        for (long t : times) {
            total_time += t;
        }
        return "" + total_time / times.length + "ms";
    }

    private String get_average_memory(long[] mems) {
        long total_mem = 0;
        for (long mem : mems) {
            total_mem += mem;
        }
        return "" + ((total_mem / mems.length) / (1000 * 1000)) + "MB";
    }
}
