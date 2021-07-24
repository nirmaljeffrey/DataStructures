package dev.nirmaljeffrey.dsalgo.datastructures.hashing;

import java.util.List;

public interface HashTable<K, V> extends Iterable<K> {

    boolean isEmpty();
    int size();
    void clear();
    V insert(K key, V value);
    V remove(K key);
    V get(K key);
    boolean containsKey(K key);
    List<K> keys();
    List<V> values();
}
