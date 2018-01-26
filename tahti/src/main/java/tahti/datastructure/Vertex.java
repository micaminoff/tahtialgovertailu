/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Michael Aminoff
 */
public class Vertex {
    private String name;
    private Set<Vertex> neighbors;
    
    /**
     * Creates a vertex
     * @param name the name to assign to this vertex. Gets a 'v_' prefix for easier hashcode comparison
     */
    public Vertex(String name) {
        this.neighbors = new HashSet<>();
        this.name = "v_" + name;
    }
    public String get_name() {
        return name;
    }
    public Set<Vertex> get_neighbors() {
        return neighbors;
    }
    public void add_neighbor(Vertex neighbor) {
        neighbors.add(neighbor);
    }
    
    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object v) {
        return name.equals(v.toString());
    }
}
