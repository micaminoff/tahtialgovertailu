/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;

import java.util.ArrayList;
import java.util.List;
import tahti.algorithm.Dijkstra;
import tahti.datastructure.Edge;
import tahti.datastructure.Graph;
import tahti.datastructure.Vertex;

/**
 *
 * @author Michael Aminoff
 */
public class Main {

    /**
     * Will in the future output metrics for various algorithms
     * For now it only serves the purpose of quick hack testing
     * @param args 
     */
    public static void main(String[] args) {
        /*
        List<Vertex> vertices = new ArrayList();
        List<Edge> edges = new ArrayList();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        Edge ab = new Edge(a, b, 2);
        Edge bd = new Edge(b, d, 2);
        Edge ac = new Edge(a, c, 5);
        Edge da = new Edge(d, a, 1);
        Edge dc = new Edge(d, c, 0);
        Edge ce = new Edge(c, e, 2);
        Edge ef = new Edge(e, f, 2);
        Edge cf = new Edge(c, f, 1);
        edges.add(ab);
        edges.add(bd);
        edges.add(ac);
        edges.add(da);
        edges.add(dc);
        edges.add(ce);
        edges.add(ef);
        edges.add(cf);
        Graph g = new Graph(vertices, edges);
        System.out.println(g);
        Dijkstra di = new Dijkstra(g);
        System.out.println("Made algo");
        System.out.println(di.run(g.get_vertices().get(0)));
         */
    }

}
