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
 * @author Michael Aminoff
 */
public class VertexMapTest {
    
    public VertexMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of put method, of class VertexMap.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Vertex key = new Vertex(54, 56);
        Vertex value = new Vertex(56, 57);
        VertexMap instance = new VertexMap();
        instance.put(key, value);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(value, (Vertex) instance.get(key));
    }

    /**
     * Test of get method, of class VertexMap.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Vertex key = new Vertex(54, 56);
        Vertex value = new Vertex(56, 57);
        VertexMap instance = new VertexMap();
        instance.put(key, value);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(value, (Vertex) instance.get(key));
    }

    /**
     * Test of get_size method, of class VertexMap.
     */
    @Test
    public void testGet_size() {
        System.out.println("get_size");
        Vertex key = new Vertex(54, 56);
        Vertex value = new Vertex(56, 57);
        VertexMap instance = new VertexMap();
        instance.put(key, value);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1, instance.get_size());
    }

    /**
     * Test of containsKey method, of class VertexMap.
     */
    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        Vertex key = new Vertex(54, 56);
        Vertex value = new Vertex(56, 57);
        VertexMap instance = new VertexMap();
        instance.put(key, value);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.containsKey(key));
    }
    
}
