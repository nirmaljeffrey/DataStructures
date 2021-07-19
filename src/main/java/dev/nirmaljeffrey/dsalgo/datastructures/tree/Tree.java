package dev.nirmaljeffrey.dsalgo.datastructures.tree;

public interface Tree<T extends Comparable<T>> {
    boolean isEmpty();
    int height();
    int size();
    boolean add(T element);
    boolean remove(T element);
    boolean contains(T element);
}
