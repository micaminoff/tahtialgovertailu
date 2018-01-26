/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Aminoff
 */
public class GraphTest {
    Vertex a = new Vertex("a");
    Vertex b = new Vertex("b");
    Edge e = new Edge(a, b, 3);
    List<Vertex> vertices = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    
    public GraphTest() {
        this.vertices.add(a);
        this.vertices.add(b);
        this.edges.add(e);
    }

    /**
     * Test of get_vertices method, of class Graph.
     */
    @Test
    public void testGet_vertices() {
        Graph g = new Graph(vertices, edges);
        List vertices = g.get_vertices();
        assertTrue(vertices.contains(a));
        assertTrue(vertices.contains(b));
    }

    /**
     * Test of get_edges method, of class Graph.
     */
    @Test
    public void testGet_edges() {
        Graph g = new Graph(vertices, edges);
        List edges = g.get_edges();
        assertTrue(edges.contains(e));
    }

    /**
     * Test of toString method, of class Graph.
     */
    @Test
    public void testToString() {
        Graph g = new Graph(vertices, edges);
        assertEquals(g.toString(), "v_a - v_b, w=3\n");
    }
    
}
