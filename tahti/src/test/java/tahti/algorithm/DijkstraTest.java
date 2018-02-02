///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tahti.algorithm;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import tahti.datastructure.Edge;
//import tahti.datastructure.Graph;
//import tahti.datastructure.Vertex;
//
///**
// *
// * @author Michael Aminoff
// */
//public class DijkstraTest {
//
//    List<Vertex> vertices = new ArrayList();
//    List<Edge> edges = new ArrayList();
//    Vertex a = new Vertex("a");
//    Vertex b = new Vertex("b");
//    Vertex c = new Vertex("c");
//    Vertex d = new Vertex("d");
//    Vertex e = new Vertex("e");
//    Vertex f = new Vertex("f");
//    Edge ab = new Edge(a, b, 2);
//    Edge bd = new Edge(b, d, 2);
//    Edge ac = new Edge(a, c, 5);
//    Edge da = new Edge(d, a, 1);
//    Edge dc = new Edge(d, c, 0);
//    Edge ce = new Edge(c, e, 2);
//    Edge ef = new Edge(e, f, 2);
//    Edge cf = new Edge(c, f, 1);
//    Graph g;
//
//    public DijkstraTest() {
//        vertices.add(a);
//        vertices.add(b);
//        vertices.add(c);
//        vertices.add(d);
//        vertices.add(e);
//        vertices.add(f);
//        edges.add(ab);
//        edges.add(bd);
//        edges.add(ac);
//        edges.add(da);
//        edges.add(dc);
//        edges.add(ce);
//        edges.add(ef);
//        edges.add(cf);
//        g = new Graph(vertices, edges);
//    }
//
//    /**
//     * Test of run method, of class Dijkstra.
//     */
//    @Test
//    public void testRun() {
//        Dijkstra di = new Dijkstra(g);
//        assertNotNull(di.run(a));
//    }
//
//}
