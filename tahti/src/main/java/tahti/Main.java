/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;

import tahti.algorithm.AStar;
import tahti.algorithm.Dijkstra;
import tahti.datastructure.Graph;

/**
 *
 * @author Michael Aminoff
 */
public class Main {

    /**
     * Will in the future output metrics for various algorithms For now it only
     * serves the purpose of quick hack testing
     *
     * @param args
     */
    public static void main(String[] args) {
        StatCollector s = new StatCollector();
        s.routine_1();
        s.routine_2();
//        String path = "./src/resources/brc100d.map";
//        Graph g = new Graph(path);
//        AStar a = new AStar(g);
//        //Dijkstra d = new Dijkstra(g);
//        //String dijkstra_result = d.run(g.get_vertices()[57][208], g.get_vertices()[149][234]);
//        System.out.println(a.getClass().getName());
//        a.run(g.get_vertices()[57][208], g.get_vertices()[149][234]);
//        System.out.println("Astar done");
//        System.out.println("Path: " + a.get_path());
//        System.out.println("Path length: " + a.get_path_length());
//        System.out.println("Vertices opened: " + a.get_vertex_count());
        
    }
}
