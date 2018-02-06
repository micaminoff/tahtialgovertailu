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
public class VertexTest {
    Vertex v;
    
    public VertexTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.v = new Vertex(15, 54, 15);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get_cost method, of class Vertex.
     */
    @Test
    public void testGet_cost() {
        System.out.println("get_cost");
        assertEquals(15, v.get_cost());
    }

    /**
     * Test of get_f method, of class Vertex.
     */
    @Test
    public void testGet_f_and_set_f() {
        v.set_f(6000);
        System.out.println("get_f");
        int expResult = 6000;
        int result = v.get_f();
        assertEquals(expResult, result);
    }

    /**
     * Test of get_row method, of class Vertex.
     */
    @Test
    public void testGet_row() {
        System.out.println("get_row");
        int expResult = 54;
        int result = v.get_row();
        assertEquals(expResult, result);
    }

    /**
     * Test of get_col method, of class Vertex.
     */
    @Test
    public void testGet_col() {
        System.out.println("get_col");
        int expResult = 15;
        int result = v.get_col();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Vertex.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = ("15,54").hashCode();
        int result = v.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Vertex.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "15,54";
        String result = v.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Vertex.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assertTrue(v.equals(new Vertex(15, 54, 15)));
    }
    
}
