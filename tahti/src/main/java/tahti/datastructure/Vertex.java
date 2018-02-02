/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

/**
 * Vertex representation
 * @author Michael Aminoff
 */
public class Vertex {
    private String id;
    private int move_cost;
    private int f;
    
    /**
     * Creates a vertex with default movecost of 1
     * @param x which column this vertex resides in in the graph
     * @param y which row ---"---
     */
    public Vertex(int x, int y) {
        this(x, y, 1);
    }
    /**
     * Creates a vertex with custom movecost
     * @param x which column this vertex resides in in the graph
     * @param y which row ---"---
     * @param move_cost the cost of the terrain in this tile
     */
    public Vertex(int x, int y, int move_cost) {
        this.id = x + "," + y;
        this.move_cost = move_cost;
    }
    
    public int get_cost() {
        return move_cost;
    }
    /**
     * Get A* heuristic value
     * @return A* heuristic value
     */
    public int get_f() {
        return f;
    }
    /**
     * Set A* heuristic value
     * @param value the new h(n) value
     */
    public void set_f(int value) {
        f = value;
    }
    public int get_row() {
        return Integer.parseInt(id.split(",")[1]);
    }
    public int get_col() {
        return Integer.parseInt(id.split(",")[0]);
    }
    public int hashCode() {
        return id.hashCode();
    }
    
    @Override
    public String toString() {
        return id;
    }
    
    @Override
    public boolean equals(Object v) {
        return id.equals(v.toString());
    }
}
