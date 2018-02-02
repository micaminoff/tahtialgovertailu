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
    private int size;
    private MapEntry[] table;
    
    public VertexMap(int size) {
        this.size = size;
        this.table = new MapEntry[size];
    }
    public VertexMap() {
        this(256);
    }
    
    
    public void put(Vertex key, int value) {
        int hash = get_hash(key);
        MapEntry entry = new MapEntry(key, value);
        
        if (table[hash] == null) {
            table[hash] = entry;
        } else {
            MapEntry current = table[hash];
            while (current.next != null) {
                if (current.get_key().equals(entry.get_key())) {
                    current.set_value(value);
                    return;
                }
                current = current.get_next();
            }
            current.next = entry;
        }
    }
    
    public int get(Vertex key) {
        int hash = get_hash(key);
        MapEntry entry = table[hash];
        while (entry != null) {
            if (entry.get_key().equals(key)) {
                return entry.get_value();
            }
            entry = entry.get_next();
        }
        return -1;
    }
    
    private int get_hash(Vertex key) {
        return key.hashCode()%size;
    }
    
    
    private class MapEntry {
        private Vertex key;
        private int value;
        private MapEntry next;
        
        
        public MapEntry(Vertex key, int value) {
            this.key = key;
            this.value = value;
        }
        public Vertex get_key() {
            return key;
        }
        public int get_value() {
            return value;
        }
        public void set_value(int value) {
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
