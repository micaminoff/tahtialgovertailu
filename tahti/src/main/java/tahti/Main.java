/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import tahti.algorithm.Dijkstra;
import tahti.datastructure.Graph;
import tahti.datastructure.Vertex;

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
        String path = "./src/resources/facebook_combined.txt";
        Vertex[] vertex_array = new Vertex[4039];
        BufferedReader reader = null;
        String[] helper;
        for (int i = 0; i < vertex_array.length; i++) {
            vertex_array[i] = new Vertex(""+i);
        }
        Graph g = new Graph(vertex_array, new ArrayList<>(), false);
        try {
            File file = new File(path);
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                helper = line.split("\\s+");
                int index_a = Integer.parseInt(helper[0]);
                int index_b = Integer.parseInt(helper[1]);
                int weight = 1;
                if (helper.length == 3) {
                    weight = Integer.parseInt(helper[2]);
                }
                g.add_edge(vertex_array[index_a], vertex_array[index_b], weight);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Dijkstra d = new Dijkstra(g);
        System.out.println(d.run(vertex_array[0], vertex_array[534]));
    }

}
