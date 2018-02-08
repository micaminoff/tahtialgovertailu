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
public class VertexComparatorTest {
    Vertex largest_f;
    Vertex largest_f2;
    Vertex smallest_f;
    VertexComparator comp;
    
    public VertexComparatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.comp = new VertexComparator();
        this.largest_f = new Vertex(1, 2, 3);
        this.largest_f2 = new Vertex(2, 3, 4);
        this.smallest_f = new Vertex(3, 4, 5);
        largest_f.set_f(5);
        largest_f2.set_f(5);
        smallest_f.set_f(0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class VertexComparator.
     */
    @Test
    public void testCompare_smaller() {
        assertTrue(comp.compare(smallest_f, largest_f) < 0);
    }
    @Test
    public void testCompare_zero() {
        assertEquals(0, comp.compare(largest_f, largest_f2));
    }
    @Test
    public void testCompare_larger() {
        assertTrue(comp.compare(largest_f, smallest_f) > 0);
    }
    
}
