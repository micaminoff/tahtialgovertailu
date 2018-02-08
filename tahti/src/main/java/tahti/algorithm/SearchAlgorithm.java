/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.algorithm;

import tahti.datastructure.Vertex;

/**
 *
 * @author Michael Aminoff
 */
public interface SearchAlgorithm {
    
    void run(Vertex start, Vertex goal);
    
    int get_path_length();
    
    String get_path();
    
    int get_vertex_count();
}