/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Michael Aminoff
 */
public class Graph {

    private Vertex[][] vertices;
    private int columns;
    private int rows;

    /**
     * Generates a graph from the input file. The program assumes the exact same
     * format as found here: http://www.movingai.com/benchmarks/
     * @param path the path to the file
     */
    public Graph(String path) {
        BufferedReader reader = null;
        try {
            File file = new File(path);
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            this.rows = Integer.parseInt(reader.readLine().split(" ")[1]);
            this.columns = Integer.parseInt(reader.readLine().split(" ")[1]);
            reader.readLine();
            this.vertices = new Vertex[columns][rows];
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < columns; col++) {
                    add_vertex(col, row, find_weight(line.charAt(col)));
                }
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Vertex[][] get_vertices() {
        return vertices;
    }

    public int get_n_columns() {
        return columns;
    }

    public int get_n_rows() {
        return rows;
    }
    public Vertex get_vertex_at(int row, int col) {
        return vertices[row][col];
    }

    private void add_vertex(int col, int row, int cost) {
        vertices[col][row] = new Vertex(col, row, cost);
    }

    /**
     * Leverages the grid system to generate a given vertex's neighbors
     * @param v the vertex whose neighbors we want
     * @return v's neighbors
     */
    public Vertex[] get_vertices_neighbors(Vertex v) {
        Vertex[] neighbors = new Vertex[4];
        for (int i = 0; i < 4; i++) {
            // A vertex can have at most 4 neighbors
            neighbors[i] = null;
        }
        int col = v.get_col();
        int row = v.get_row();
        if (row > 0) {
            neighbors[0] = vertices[col][row - 1];
        }
        if (col > 0) {
            neighbors[1] = vertices[col - 1][row];
        }
        if (row < rows - 1) {
            neighbors[2] = vertices[col][row + 1];
        }
        if (col < columns - 1) {
            neighbors[3] = vertices[col + 1][row];
        }
        return neighbors;
    }
    
    public void reset_graph() {
        for (Vertex[] vs : vertices) {
            for (Vertex v : vs) {
                v.set_f(0);
            }
        }
    }

    /**
     * Helper method to parse the file input
     * @param c character to be interpreted
     * @return an arbitrary weight (subject to change)
     */
    private int find_weight(char c) {
        switch (c) {
            case '.':
                return 1;
            case 'G':
                return 2;
            case 'S':
                return 5;
            case 'W':
                return 10;
            default:
                break;
        }
        return -1;
    }

    /**
     * This is so intense it should probably never be used.
     * @return string representation
     */
    @Override
    public String toString() {
        String rep = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rep += "" + vertices[j][i].get_cost();
            }
            rep += "\n";
        }
        return rep;
    }
}
