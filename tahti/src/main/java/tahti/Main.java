/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tahti.datastructure.Edge;
import tahti.datastructure.Graph;
import tahti.datastructure.Vertex;

/**
 *
 * @author Michael Aminoff
 */
public class Main {
    
    public static void main(String[] args) {
        Random r = new Random();
        List<Vertex> vertices = new ArrayList();
        List<Edge> edges = new ArrayList();
        for (int i=0; i < 10; i++) {
            vertices.add(new Vertex(""+i));
        }
        for (int i = 0; i < 20; i++) {
            edges.add(new Edge(vertices.get(r.nextInt(10)), vertices.get(r.nextInt(10))));
        }
        Graph g = new Graph(vertices, edges);
        System.out.println(g);
    }
    
}
