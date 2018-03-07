/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michael
 */
public class GraphTest {
    private Graph g;
    
    public GraphTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.g = new Graph("./resources/brc100d.map");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get_vertices method, of class Graph.
     */
    @Test
    public void testGet_vertices() {
        System.out.println("get_vertices");
        Vertex[][] vertices = g.get_vertices();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(vertices.length, 512);
    }

    /**
     * Test of get_n_columns method, of class Graph.
     */
    @Test
    public void testGet_n_columns() {
        System.out.println("get_n_columns");
        int expResult = 512;
        int result = g.get_n_columns();
        assertEquals(expResult, result);
    }

    /**
     * Test of get_n_rows method, of class Graph.
     */
    @Test
    public void testGet_n_rows() {
        System.out.println("get_n_rows");
        int expResult = 492;
        int result = g.get_n_rows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get_vertices_neighbors method, of class Graph.
     */
    @Test
    public void testGet_vertices_neighbors() {
        System.out.println("get_vertices_neighbors");
        Vertex v = g.get_vertex_at(56, 54);
        int expResult = 4;
        int result = g.get_vertices_neighbors(v).length;
        assertEquals(expResult, result);
    }

    /**
     * Test of get_vertex_at method, of class Graph.
     */
    @Test
    public void testGet_vertex_at() {
        System.out.println("get_vertex_at");
        int x = 54;
        int y = 54;
        Vertex result = g.get_vertex_at(y, x);
        assertTrue(result != null);
    }

    /**
     * Test of reset_graph method, of class Graph.
     */
    @Test
    public void testReset_graph() {
        System.out.println("reset_graph");
        g.get_vertex_at(56, 54).set_f(12);
        g.reset_graph();
        assertEquals(g.get_vertex_at(56, 54).get_f(), 0);
    }
    
    @Test
    public void testGraphGen() {
        Graph g2 = new Graph("./resources/brc100d.map");
        assertEquals(g2.get_vertex_at(56, 54).get_f(), 0);
    }
    
}
