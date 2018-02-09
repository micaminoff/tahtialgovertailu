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
public class VertexMap {

    private int max_size;
    private int populated;
    private MapEntry[] table;
    private double load_factor;

    public VertexMap(int max_size) {
        this.max_size = max_size;
        this.table = new MapEntry[max_size];
        this.populated = 0;
        this.load_factor = 0.75;
    }

    public VertexMap() {
        this(2459);
    }

    public void put(Vertex key, Vertex value) {
        int hash = get_hash(key);
        MapEntry entry = new MapEntry(key, value);

        if (table[hash] == null) {
            table[hash] = entry;
        } else {
            MapEntry current = table[hash];
            if (current.get_key() == entry.get_key()) {
                current.set_value(entry.value);
            } else {
                while (current.next != null) {
                    if (current.get_key().equals(entry.get_key())) {
                        current.set_value(value);
                        break;
                    }
                    current = current.get_next();
                }
            }
            current.next = entry;
        }
        populated++;
        if (populated > load_factor * max_size) {
            max_size *= 2;
            rebuild();
        }
    }

    public Vertex get(Vertex key) {
        int hash = get_hash(key);
        MapEntry entry = table[hash];
        while (entry != null) {
            if (entry.get_key().equals(key)) {
                return entry.get_value();
            }
            entry = entry.get_next();
        }
        return null;
    }

    private int get_hash(Vertex key) {
        return key.hashCode() % max_size;
    }

    public int get_size() {
        return populated;
    }

    private void rebuild() {
        MapEntry[] old_table = table.clone();
        table = new MapEntry[max_size];
        for (MapEntry m : old_table) {
            if (m == null) {
                continue;
            }
            put(m.key, m.value);
            MapEntry current = m;
            while (current.get_next() != null) {
                current = current.get_next();
                put(current.key, current.value);
            }
        }
    }

    private class MapEntry {

        private Vertex key;
        private Vertex value;
        private MapEntry next;

        public MapEntry(Vertex key, Vertex value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Vertex get_key() {
            return key;
        }

        public Vertex get_value() {
            return value;
        }

        public void set_value(Vertex value) {
            this.value = value;
        }

        public MapEntry get_next() {
            return next;
        }

        public void set_next(MapEntry next) {
            this.next = next;
        }
    }

}
