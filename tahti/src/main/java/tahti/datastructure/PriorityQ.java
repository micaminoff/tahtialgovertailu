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
public class PriorityQ {

    private QItem[] table;
    private VertexComparator comp;
    private int max_size;
    private int populated;

    public PriorityQ(int max_size) {
        this.table = new QItem[max_size];
        this.comp = new VertexComparator();
        this.max_size = max_size;
        this.populated = 0;
    }

    public PriorityQ() {
        this(8);
    }

    public void add(Vertex v) {
        QItem item = new QItem(v);
        table[populated + 1] = item;
        populated++;
        if (max_size - populated == 1) {
            increase_size();
        }
        propagate_up();
    }

    public Vertex poll() {
        QItem item = table[1];
        table[1] = table[populated];
        populated--;
        propagate_down();
        if (max_size - populated > 2*populated) {
            decrease_size();
        }
        return item.get_vertex();
    }
    
    public boolean is_empty() {
        return populated == 0;
    }

    private void propagate_up() {
        int current = populated;
        QItem q = table[current];
        while (table[current / 2] != null && q.get_priority() < table[current / 2].get_priority()) {
            table[current] = table[current / 2];
            current /= 2;
        }
        table[current] = q;

    }

    private void increase_size() {
        max_size *= 2;
        QItem[] new_table = new QItem[max_size];
        for (int i = 1; i <= populated; i++) {
            new_table[i] = table[i];
        }
        table = new_table;
    }

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

    private class QItem {

        private Vertex v;
        private int priority;

        public QItem(Vertex v) {
            this.v = v;
            this.priority = v.get_f();
        }

        public void update_priority(int priority) {
            this.priority = priority;
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
