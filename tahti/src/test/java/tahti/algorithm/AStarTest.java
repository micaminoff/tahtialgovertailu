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
 * @author michael
 */
public class AStarTest {
    private Graph g;
    private AStar a;
    
    public AStarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        g = new Graph("./src/resources/brc100d.map");
        a = new AStar(g);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class AStar.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        a.run(source, target);
        assertTrue(a.get_path_length() == 4);
    }
    
}
