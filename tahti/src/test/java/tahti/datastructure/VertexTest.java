/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Aminoff
 */
public class VertexTest {
    
    public VertexTest() {
    }

    /**
     * Test of get_name method, of class Vertex.
     */
    @Test
    public void testGet_name() {
        Vertex a = new Vertex("a");
        assertEquals(a.get_name(), "v_a");
    }

    /**
     * Test of get_neighbors method, of class Vertex.
     */
    @Test
    public void testGet_neighbors() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b);
        assertTrue(a.get_neighbors().contains(b));
    }

    /**
     * Test of add_neighbor method, of class Vertex.
     */
    @Test
    public void testAdd_neighbor() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        a.add_neighbor(b);
        assertTrue(a.get_neighbors().contains(b));
    }

    /**
     * Test of toString method, of class Vertex.
     */
    @Test
    public void testToString() {
        Vertex a = new Vertex("a");
        assertEquals(a.toString(), "v_a");
    }

    /**
     * Test of equals method, of class Vertex.
     */
    @Test
    public void testEquals() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        assertFalse(a.equals(b));
        assertTrue(a.equals(a));
    }
    
}
