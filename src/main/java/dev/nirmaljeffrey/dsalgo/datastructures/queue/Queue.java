package dev.nirmaljeffrey.dsalgo.datastructures.queue;

public interface Queue<T> extends Iterable<T> {

    void enqueue(T data);

    T dequeue();

    T peek();

    boolean isEmpty();

}
