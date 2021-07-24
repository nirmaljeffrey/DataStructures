package dev.nirmaljeffrey.dsalgo.datastructures.hashing;

import dev.nirmaljeffrey.dsalgo.common.HashEntry;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class HashTableSeparateChaining<K, V> implements HashTable<K, V> {
     private static final double DEFAULT_LOAD_FACTOR = 0.75;
     private static final int DEFAULT_CAPACITY = 3;
     // No of elements in hash table / size of hashtable
     private double maxLoadFactor;
     private int capacity = 0;
     // threshold = capacity * maxLoadFactor
     private int threshold = 0;
     private int size = 0;
     private LinkedList<HashEntry<K, V>>[] hashtable;
    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity) {
       this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity, double loadFactor) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Illegal Capacity");
        }
        if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isFinite(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor");
        }
        this.maxLoadFactor = loadFactor;
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        threshold = (int) (this.capacity * maxLoadFactor);
         hashtable = new LinkedList[this.capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(hashtable, null);
        size = 0;
    }

    @Override
    public V insert(K key, V value) {
        if (key == null) {
            return null;
        }
        HashEntry<K,V> entry = new HashEntry<>(key, value);
        int bucketIndex = normalizeIndex(entry.hash);
        return bucketInsertEntry(bucketIndex, entry);
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(bucketIndex, key);
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        int bucketIndex = normalizeIndex(key.hashCode());
        HashEntry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
           return false;
        }
        int bucketIndex = normalizeIndex(key.hashCode());
        HashEntry<K,V> entry = bucketSeekEntry(bucketIndex, key);
        return entry != null;
    }

    @Override
    public List<K> keys() {
        ArrayList<K> keys = new ArrayList<>(size);
        for (LinkedList<HashEntry<K, V>> hashEntries : hashtable) {
            if (hashEntries != null) {
                for (HashEntry<K, V> entry : hashEntries) {
                    keys.add(entry.key);
                }
            }
        }
        return keys;
    }

    @Override
    public List<V> values() {
        ArrayList<V> values = new ArrayList<>(size);
        for (LinkedList<HashEntry<K, V>> hashEntries : hashtable) {
            if (hashEntries != null) {
                for (HashEntry<K, V> entry : hashEntries) {
                    values.add(entry.value);
                }
            }
        }
        return values;
    }

    private int normalizeIndex(int keyHash) {
        return Math.abs(keyHash) % capacity;
    }

    private HashEntry<K, V> bucketSeekEntry(int bucketIndex, K key) {
        if (key == null) {
            return null;
        }
        LinkedList<HashEntry<K, V>> bucket = hashtable[bucketIndex];

        if (bucket == null) {
            return null;
        }

        for (HashEntry<K, V> entry : bucket) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    private V bucketRemoveEntry(int bucketIndex, K key) {
        if (key == null) {
            return null;
        }
        HashEntry<K, V> entryToBeRemoved = bucketSeekEntry(bucketIndex, key);
        if (entryToBeRemoved == null) {
            return null;
        }
        LinkedList<HashEntry<K,V>> bucket = hashtable[bucketIndex];
        if (bucket == null) {
            return null;
        }
        bucket.remove(entryToBeRemoved);
        size--;
        return entryToBeRemoved.value;
    }
    // Returns old value before updating
    private V bucketInsertEntry(int bucketIndex, HashEntry<K, V> entry) {
        LinkedList<HashEntry<K,V>> bucket = hashtable[bucketIndex];
        if (bucket == null) {
            bucket = hashtable[bucketIndex] = new LinkedList<>();
        }
        HashEntry<K,V> existingEntry = bucketSeekEntry(bucketIndex, entry.key);
        if (existingEntry == null) {
            bucket.add(entry);
            if (++size > threshold) {
                resizeTable();
            }
            return null; // old value is null, only insertion occured
        } else {
            V oldValue = existingEntry.value;
            existingEntry.value = entry.value;
            return oldValue;
        }
    }

    private void resizeTable() {
        capacity *= 2;
        threshold = (int) (capacity * maxLoadFactor);
        LinkedList<HashEntry<K,V>>[] newTable = new LinkedList[capacity];

        for (LinkedList<HashEntry<K, V>> hashEntries : hashtable) {
            if (hashEntries != null) {
                for (HashEntry<K,V> entry: hashEntries) {
                    int bucketIndex = normalizeIndex(entry.hash);
                    LinkedList<HashEntry<K,V>> newBucket = newTable[bucketIndex];
                    if (newBucket == null) {
                        newTable[bucketIndex] = newBucket = new LinkedList<>();
                    }
                    newBucket.add(entry);
                }
                hashEntries.clear();
                hashEntries = null;
            }
        }

        hashtable = newTable;
    }

    @NotNull
    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public K next() {
                return null;
            }
        };
    }
}
