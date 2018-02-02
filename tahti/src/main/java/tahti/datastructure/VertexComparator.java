/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

import java.util.Comparator;

/**
 *
 * @author Michael Aminoff
 */
public class VertexComparator implements Comparator<Vertex>
{
    /**
     * Compares two vertices' A* heuristic values
     * @param x one vertex
     * @param y the other vertex
     * @return -1, 0, or 1 if x.f < y.f, x.f=y.f, or x.f > y.f
     */
    @Override
    public int compare(Vertex x, Vertex y)
    {
        if (x.get_f()< y.get_f())
        {
            return -1;
        }
        if (x.get_f() > y.get_f())
        {
            return 1;
        }
        return 0;
    }
}
