/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

/**
 *
 * @author Michael Aminoff
 */
public class VertexStack {

    private int total;

    private Node top;
    
    public VertexStack() {
        this.total = 0;
    }

    public void push (Vertex vert) {
        Node current = top;
        top = new Node();
        top.v = vert;
        top.next = current;
        total++;
    }

    public Vertex pop() {
        if (top == null) {
            return null;
        }
        Vertex vert = top.v;
        top = top.next;
        total--;
        return vert;
    }

    public int get_size() {
        return total;
    }
    
    public boolean isEmpty() {
        return total == 0;
    }
    
    public boolean contains(Vertex to_find) {
        Node n = top;
        while (n != null) {
            if (n.v == to_find) {
                return true;
            }
            n = n.next;
        }
        return false;
    }
    
    private class Node {
        private Vertex v;
        private Node next;
    }

}
