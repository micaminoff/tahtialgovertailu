/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;


/**
 * Binary min heap implementation of priority queue
 * Psuedocode from Kivinen, CLRS, http://www.comp.dit.ie/rlawlor/Alg_DS/heaps/PQs%20and%20Heaps.pdf
 * and http://faculty.cs.niu.edu/~freedman/340/340notes/340heap.htm
 * @author Michael Aminoff
 */
public class PriorityQ {

    private QItem[] table;
    private int max_size;
    private int populated;

    /**
     * Constructor for the Priority Queue
     * @param max_size the initial size of the backing array
     */
    public PriorityQ(int max_size) {
        this.table = new QItem[max_size];
        this.max_size = max_size;
        this.populated = 0;
    }

    public PriorityQ() {
        this(8);
    }
    
    private int parent(int i) {
        return (int) Math.floor(i/2);
    }
    private int left(int i) {
        return 2*i;
    }
    private int right(int i) {
        return 2*i + 1;
    }

    /**
     * Adds a vertex to the priority queue. First creates a QItem with the vertex's f-value as
     * the priority of the item.
     * @param v A vertex we want to add to the queue
     */
    public void add(Vertex v) {
        // Place this item in the first free spot in the array and keep track of where the last
        // item is located
        QItem item = new QItem(v);
        table[populated + 1] = item;
        populated++;
        
        // Move the newly added item "up" in the heap until it comes across a smaller item
        propagate_up();
        // If we've almost filled up the backing array, double the size
        if (max_size - populated == 1) {
            increase_size();
        } 
    }
    
    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        if (right <= populated) {
            int smallest;
            if (table[left].get_priority() < table[right].get_priority()) {
                smallest = left;
            } else {
                smallest = right;
            }
            if (table[i].get_priority() > table[smallest].get_priority()) {
                swap(i, smallest);
                heapify(smallest);
            }
        } else if (left == populated && table[i].get_priority() > table[left].get_priority()) {
            swap(i, left);
        }
    }
    
    private void swap(int a, int b) {
        QItem temp = table[a];
        table[a] = table[b];
        table[b] = temp;
    }

    /**
     * Removes and returns the vertex with the highest priority (smallest f, top of heap)
     * @return the vertex with the smallest f
     */
    public Vertex poll() {
        // Place the last item at the top, thus breaking the heap condition and keep track
        // of where the new last item is
        QItem item = table[1];
        table[1] = table[populated];
        populated--;
        
        // Move the top item down until it comes across a larger one
        heapify(1);
        // Decrease array size if we have lots of wasted space
        if (max_size - populated > 2*populated) {
            if (max_size > 8) {
                decrease_size();
            }
        }
        return item.get_vertex();
    }
    
    /**
     * Checks if our priority queue is empty
     * @return true if empty, otherwise false
     */
    public boolean is_empty() {
        return populated == 0;
    }

    /**
     * Ok this is a fun one. We start by selecting the last item in our heap as a comparator.
     * If this item is not already at the top, and is smaller than its parent, we swap their places.
     * Then we repeat until the item finds its position.
     */
    private void propagate_up() {
        int current = populated;
        QItem q = table[current];
        while (table[current / 2] != null && q.get_priority() < table[current / 2].get_priority()) {
            table[current] = table[current / 2];
            current /= 2;
        }
        table[current] = q;

    }

    /**
     * Doubles the size of the backing array
     */
    private void increase_size() {
        max_size *= 2;
        QItem[] new_table = new QItem[max_size];
        for (int i = 1; i <= populated; i++) {
            new_table[i] = table[i];
        }
        table = new_table;
    }

    /**
     * Does the inverse of propagate_up
     */
    private void propagate_down() {
        int current = 1;
        QItem q = table[current];
        while (current < populated/2) {
            int j = 2*current;
            if (j < populated && table[j].get_priority() > table[j+1].get_priority()) {
                j++;
            }
            if (q.get_priority() <= table[j].get_priority()) {
                break;
            }
            table[current] = table[j];
            current = j;
        }
        table[current] = q;
    }

    /**
     * Halves the size of the backing array
     */
    private void decrease_size() {
        max_size /= 2;
        QItem[] new_table = new QItem[max_size];
        for (int i = 1; i <= populated; i++) {
            new_table[i] = table[i];
        }
        table = new_table;
    }
    
    @Override
    public String toString() {
        String to_return = "";
        for (int i = 1; i <= populated; i++) {
            to_return += table[i].toString();
        }
        return to_return;
    }

    /**
     * Private helper class of the PriorityQ, helps with the ordering of elements by providing
     * direct access to a vertex's f-value
     */
    private class QItem {

        private final Vertex v;
        private final int priority;

        public QItem(Vertex v) {
            this.v = v;
            this.priority = v.get_f();
        }

        public int get_priority() {
            return priority;
        }

        public Vertex get_vertex() {
            return v;
        }
        
        @Override
        public String toString() {
            return this.v + ", (p=" + this.priority + "), ";
        }
    }
}
