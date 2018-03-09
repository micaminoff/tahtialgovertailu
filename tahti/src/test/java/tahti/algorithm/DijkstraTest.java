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
public class DijkstraTest {

    private Graph g;
    private Dijkstra d;

    public DijkstraTest() {
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
        d = new Dijkstra(g);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class Dijkstra.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        d.run(source, target);
        assertTrue(d.get_path_length() == 4);
    }

    @Test
    public void testImpassableStartError() {
        System.out.println("run impassable start");
        Vertex source = g.get_vertex_at(178, 457);
        Vertex target = g.get_vertex_at(57, 212);
        d.run(source, target);
        assertTrue(d.get_path_length() == -1);
    }

    @Test
    public void testDisjointAreas() {
        System.out.println("run disjoint areas");
        g = new Graph("./resources/AR0300SR.map");
        d = new Dijkstra(g);
        Vertex source = g.get_vertex_at(71, 368);
        Vertex target = g.get_vertex_at(158, 381);
        d.run(source, target);
        assertTrue(d.get_path_length() == -1);
        assertEquals(d.get_path(), "No path available");
    }

    @Test
    public void testGetPath() {
        System.out.println("get path");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        d.run(source, target);
        assertTrue(d.get_path().equals("57,211 - 57,211 - 57,210 - 57,209 - 57,208"));
    }

    @Test
    public void testGetPathLength() {
        System.out.println("get path length");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        d.run(source, target);
        assertTrue(d.get_path_length() == 4);
    }

    @Test
    public void testGetVertexCount() {
        System.out.println("get vertex count");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        d.run(source, target);
        System.out.println(d.get_vertex_count());
        assertEquals(d.get_vertex_count(), 100);
    }

    @Test
    public void testGetPathWeight() {
        System.out.println("get path length");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        d.run(source, target);
        assertTrue(d.get_path_weight() == 4);
    }

    @Test
    public void testGetMaxOpen() {
        System.out.println("get max open");
        Vertex source = g.get_vertex_at(57, 208);
        Vertex target = g.get_vertex_at(57, 212);
        d.run(source, target);
        assertEquals(d.get_max_open(), 56);
    }

}
