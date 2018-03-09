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
public class VertexStackTest {
    
    private VertexStack vs;
    private Vertex a;
    private Vertex b;
    private Vertex c;
    
    public VertexStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        vs = new VertexStack();
        a = new Vertex(0, 0, 0);
        b = new Vertex(1, 1, 1);
        c = new Vertex(2, 2, 2);
    }
    
    @After
    public void tearDown() {
        vs = new VertexStack();
    }

    /**
     * Test of push method, of class VertexStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        vs.push(a);
        vs.push(b);
        assertTrue(vs.contains(a));
        assertTrue(vs.contains(b));
    }

    /**
     * Test of pop method, of class VertexStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        vs.push(a);
        assertEquals(a, vs.pop());
        
        vs.push(a);
        vs.push(b);
        assertEquals(b, vs.pop());
    }

    /**
     * Test of get_size method, of class VertexStack.
     */
    @Test
    public void testGet_size() {
        assertEquals(0, vs.get_size());
        vs.push(a);
        assertEquals(1, vs.get_size());
        vs.push(b);
        assertEquals(2, vs.get_size());
        vs.pop();
        assertEquals(1, vs.get_size());
    }

    /**
     * Test of isEmpty method, of class VertexStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertTrue(vs.isEmpty());
        vs.push(a);
        assertFalse(vs.isEmpty());
        vs.pop();
        assertTrue(vs.isEmpty());
    }

    /**
     * Test of contains method, of class VertexStack.
     */
    @Test
    public void testContains() {
        System.out.println("push");
        vs.push(a);
        vs.push(b);
        assertTrue(vs.contains(a));
        assertTrue(vs.contains(b));
        vs.pop();
        assertFalse(vs.contains(b));
    }
    
}
