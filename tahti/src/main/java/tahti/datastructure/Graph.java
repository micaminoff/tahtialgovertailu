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
            int y = 0;
            while ((line = reader.readLine()) != null) {
                for (int x = 0; x < columns; x++) {
                    add_vertex(x, y, find_weight(line.charAt(x)));
                }
                y++;
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

    private void add_vertex(int x, int y, int cost) {
        vertices[x][y] = new Vertex(x, y, cost);
    }

    public Vertex[] get_vertices_neighbors(Vertex v) {
        Vertex[] neighbors = new Vertex[4];
        for (int i = 0; i < 4; i++) {
            neighbors[i] = null;
        }
        int x = v.get_col();
        int y = v.get_row();
        if (y > 0) {
            neighbors[0] = vertices[x][y - 1];
        }
        if (x > 0) {
            neighbors[1] = vertices[x - 1][y];
        }
        if (y < rows - 1) {
            neighbors[2] = vertices[x][y + 1];
        }
        if (x < columns - 1) {
            neighbors[3] = vertices[x + 1][y];
        }
        return neighbors;
    }

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
