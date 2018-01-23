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
public class Edge {
    private String id;
    private Vertex vertex_a;
    private Vertex vertex_b;
    private int weight;
    
    public Edge(Vertex a, Vertex b, int weight) {
        this.vertex_a = a;
        this.vertex_b = b;
        this.id = "" + (a.toString() + b.toString()).hashCode();
        this.weight = weight;
    }
    public Edge(Vertex a, Vertex b) {
        this(a, b, 1);
    }
    
    public String getId() {
        return id;
    }
    public int getWeight() {
        return weight;
    }
    public Vertex getSource() {
        return vertex_a;
    }
    public Vertex getDestination() {
        return vertex_b;
    }
    
    @Override
    public String toString() {
        return vertex_a + " - " + vertex_b + ", w=" + weight;
    }
}
