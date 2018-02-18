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
public class PriorityQTest {
    
    public PriorityQTest() {
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
     * Test of add method, of class PriorityQ.
     */
    @Test
    public void testAdd() {
        PriorityQ instance = new PriorityQ();
        Vertex v = new Vertex(0, 0);
        v.set_f(100);
        instance.add(v);
        Vertex w = new Vertex(0, 1);
        w.set_f(50);
        instance.add(w);
        Vertex x = new Vertex(0, 2);
        x.set_f(120);
        instance.add(x);
        Vertex y = new Vertex(0, 3);
        y.set_f(12);
        instance.add(y);
        assertEquals(instance.toString(), "0,3, (p=12), 0,1, (p=50), 0,2, (p=120), 0,0, (p=100), ");
    }
    
    @Test
    public void testPoll() {
        PriorityQ instance = new PriorityQ();
        Vertex v = new Vertex(0, 0);
        v.set_f(100);
        instance.add(v);
        Vertex w = new Vertex(0, 1);
        w.set_f(50);
        instance.add(w);
        Vertex x = new Vertex(0, 2);
        x.set_f(120);
        instance.add(x);
        Vertex y = new Vertex(0, 3);
        y.set_f(12);
        instance.add(y);
        Vertex test = instance.poll();
        assertEquals(test.get_f(), 12);
        Vertex test2 = instance.poll();
        assertEquals(test2.get_f(), 50);
    }
    
    @Test
    public void testIsEmpty() {
        PriorityQ instance = new PriorityQ();
        Vertex v = new Vertex(0, 0);
        v.set_f(100);
        instance.add(v);
        Vertex w = new Vertex(0, 1);
        w.set_f(50);
        instance.add(w);
        Vertex x = new Vertex(0, 2);
        x.set_f(120);
        instance.add(x);
        Vertex y = new Vertex(0, 3);
        y.set_f(12);
        instance.add(y);
        Vertex test = instance.poll();
        instance.poll();
        instance.poll();
        instance.poll();
        assertEquals(instance.is_empty(), true);
    }
    
    
}
