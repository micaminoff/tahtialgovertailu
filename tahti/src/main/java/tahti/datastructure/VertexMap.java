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

    public VertexMap(int max_size) {
        this.max_size = max_size;
        this.table = new MapEntry[max_size];
        this.populated = 0;
    }

    public VertexMap() {
        this(256);
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

    private class MapEntry {

        private Vertex key;
        private Vertex value;
        private MapEntry next;

        public MapEntry(Vertex key, Vertex value) {
            this.key = key;
            this.value = value;
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
