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
     * @param col which column this vertex resides in in the graph
     * @param row which row ---"---
     */
    public Vertex(int col, int row) {
        this(col, row, 1);
    }
    /**
     * Creates a vertex with custom movecost
     * @param col which column this vertex resides in in the graph
     * @param row which row ---"---
     * @param move_cost the cost of the terrain in this tile
     */
    public Vertex(int col, int row, int move_cost) {
        this.id = col + "," + row;
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
