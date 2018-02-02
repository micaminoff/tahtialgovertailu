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
    private String id;
    private int move_cost;
    private int f;
    
    public Vertex(int x, int y) {
        this(x, y, 1);
    }
    public Vertex(int x, int y, int move_cost) {
        this.id = x + "," + y;
        this.move_cost = move_cost;
    }
    
    public int get_cost() {
        return move_cost;
    }
    public int get_f() {
        return f;
    }
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
