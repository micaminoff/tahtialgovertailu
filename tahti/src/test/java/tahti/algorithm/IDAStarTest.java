/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.algorithm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tahti.datastructure.Graph;
import tahti.datastructure.Vertex;

/**
 *
 * @author Michael Aminoff
 */
public class IDAStarTest {
    private Graph g;
    private IDAStar ida;
    
    public IDAStarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        g = new Graph("./resources/brc100d.map");
        ida = new IDAStar(g);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRun() {
        System.out.println("run");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        ida.run(source, target);
        assertTrue(ida.get_path_length() == 4);
    }
    
    @Test
    public void testImpassableStartError() {
        System.out.println("run impassable start");
        Vertex source = g.get_vertex_at(178, 457);
        Vertex target = g.get_vertex_at(57, 212);
        ida.run(source, target);
        assertTrue(ida.get_path_length() == -1);
    }

    @Test
    public void testGetPath() {
        System.out.println("get path");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        ida.run(source, target);
        assertTrue(ida.get_path().equals("57,211 - 57,211 - 57,210 - 57,209 - 57,208"));
    }

    @Test
    public void testGetVertexCount() {
        System.out.println("get vertex count");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        ida.run(source, target);
        assertEquals(ida.get_vertex_count(), 5);
    }

    @Test
    public void testGetMaxOpen() {
        System.out.println("get max open");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        ida.run(source, target);
        assertEquals(ida.get_vertex_count(), 5);
    }
    
}
