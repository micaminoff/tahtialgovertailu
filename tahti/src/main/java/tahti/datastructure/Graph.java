/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael Aminoff
 */
public class Graph {
    private Vertex[] vertices;
    private List<Edge> edges;
    private boolean directed;
    
    
    public Graph(Vertex[] vertices, List<Edge> edges, boolean directed) {
        this.vertices = vertices;
        this.edges = edges;
        this.directed = directed;
    }
    public Graph(List<Edge> edges, int max_vertex, boolean directed) {
        this.vertices = new Vertex[max_vertex+1];
        this.edges = edges;
        this.directed = directed;
    }
    public Graph() {
        this(new ArrayList<>(), 1000, true);
    }
    
    public Vertex[] get_vertices() {
        return vertices;
    }
    public List<Edge> get_edges() {
        return edges;
    }
    public void add_edge(Vertex a, Vertex b, int weight) {
        int a_index = Integer.parseInt(a.get_name());
        int b_index = Integer.parseInt(b.get_name());
        edges.add(new Edge(vertices[a_index], vertices[b_index], weight));
        if (!directed) {
            edges.add((new Edge(vertices[b_index], vertices[a_index], weight)));
        }
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
