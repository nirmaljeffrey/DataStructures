package dev.nirmaljeffrey.datastructures.stack;

public interface Stack<T> extends Iterable<T> {
    int size();
    boolean isEmpty();
    void push(T data);
    T pop();
    T peek();

}
