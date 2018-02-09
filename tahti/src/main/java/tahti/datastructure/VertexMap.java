/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.datastructure;

/**
 * Basically a HashTable
 * @author Michael Aminoff
 */
public class VertexMap {

    private int max_size;
    private int populated;
    private MapEntry[] table;
    private double load_factor;

    /**
     * Initializes the datastructure
     * @param max_size 
     */
    public VertexMap(int max_size) {
        this.max_size = max_size;
        this.table = new MapEntry[max_size];
        this.populated = 0;
        this.load_factor = 0.75;
    }

    /**
     * Default, sets max size to an arbitrary number
     */
    public VertexMap() {
        this(1024);
    }

    /**
     * Puts the given combination in the table at index=key.hash
     * If the given key is already in the table - update the value
     * If the given index is occupied by another key, add this entry last in the chain
     * @param key A Vertex
     * @param value A Vertex
     */
    public void put(Vertex key, Vertex value) {
        int hash = get_hash(key);
        MapEntry entry = new MapEntry(key, value);

        if (table[hash] == null) {
            // If this index is free simply add the entry
            table[hash] = entry;
            update();
        } else {
            // Get the first Vertex at this index
            MapEntry current = table[hash];
            if (current.get_key() == entry.get_key()) {
                // If the key already exists, update its value
                current.set_value(entry.value);
                return;
            } else {
                while (current.next != null) {
                    current = current.get_next();
                    if (current.get_key() == entry.get_key()) {
                        // If the key already exists, update value
                        current.set_value(value);
                        return;
                    }
                }
            }
            // If we get all the way here, we caused a collision and this key doesn't exist
            // in the table yet. So we set it last.
            current.next = entry;
            update();
        }
    }
    
    /**
     * Invoked if we've entered a new element in the table.
     * Checks if the load on the table is too high and rebuild as necessary.
     */
    public void update() {
        populated++;
        if (populated > load_factor * max_size) {
            // Doubles the size of the table
            max_size *= 2;
            rebuild();
        }
    }

    /**
     * Gets the Vertex associated with this key
     * @param key The key whose value we want to know
     * @return The value this key is associated with
     */
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

    /**
     * Rebuilds the table after it's increased in size.
     */
    private void rebuild() {
        // Copy the old table
        MapEntry[] old_table = table.clone();
        // Create a new table and set it as class variable
        table = new MapEntry[max_size];
        for (MapEntry m : old_table) {
            // For each index in the table
            if (m == null) {
                continue;
            }
            // Insert the found entry in the new table
            put(m.key, m.value);
            MapEntry current = m;
            while (current.get_next() != null) {
                // Go through all elements in this index
                current = current.get_next();
                put(current.key, current.value);
            }
        }
    }

    /**
     * Class for constructing Vertex,Vertex-pairs. Only used as a backing structure for VertexMap.
     */
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
