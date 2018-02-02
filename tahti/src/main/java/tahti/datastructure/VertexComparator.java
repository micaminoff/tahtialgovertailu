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
    @Override
    public int compare(Vertex x, Vertex y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
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
