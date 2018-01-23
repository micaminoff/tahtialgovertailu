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
public class Vertex {
    private String name;
    
    public Vertex(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
