/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import java.util.List;

/**
 *
 * @author Michael Aminoff
 */
public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;
    
    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }
    
    public List<Vertex> getVertices() {
        return vertices;
    }
    public List<Edge> getEdges() {
        return edges;
    }
    
    @Override
    public String toString() {
        String toReturn = "";
        for (Edge e : edges) {
            toReturn += e.toString();
            toReturn += "\n";
        }
        return toReturn;
    }
}
