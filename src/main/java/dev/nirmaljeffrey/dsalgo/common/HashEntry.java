package dev.nirmaljeffrey.dsalgo.common;

public class HashEntry<K,V> {
    public int hash;
    public K key;
    public V value;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }


    public boolean equals(HashEntry<K,V> otherEntry) {
        if (hash != otherEntry.hash) {
            return false;
        }
        return key.equals(otherEntry.key);
    }

    @Override
    public String toString() {
        return key + " => " + value;
    }
}
