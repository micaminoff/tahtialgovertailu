/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import static org.junit.Assert.*;

/**
 *
 * @author Michael Aminoff
 */
public class EdgeTest {
    Vertex a = new Vertex("a");
    Vertex b = new Vertex("b");
    
    public EdgeTest() {
    }

    /**
     * Test of get_id method, of class Edge.
     */
    @org.junit.Test
    public void testGet_id() {
        Edge e = new Edge(a, b, 5);
        assertEquals(e.get_id(), "v_av_b".hashCode()+"");
    }

    /**
     * Test of get_w method, of class Edge.
     */
    @org.junit.Test
    public void testGet_w() {
        Edge e = new Edge(a, b, 5);
        assertEquals(e.get_w(), 5);
    }

    /**
     * Test of get_source method, of class Edge.
     */
    @org.junit.Test
    public void testGet_source() {
        Edge e = new Edge(a, b, 5);
        assertEquals(e.get_source(), a);
    }

    /**
     * Test of get_dest method, of class Edge.
     */
    @org.junit.Test
    public void testGet_dest() {
        Edge e = new Edge(a, b, 5);
        assertEquals(e.get_dest(), b);
    }

    /**
     * Test of toString method, of class Edge.
     */
    @org.junit.Test
    public void testToString() {
        Edge e = new Edge(a, b, 5);
        assertEquals(e.toString(), "v_a - v_b, w=5");
    }
    
}
