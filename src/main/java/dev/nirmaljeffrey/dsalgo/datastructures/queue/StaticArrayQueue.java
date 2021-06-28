package dev.nirmaljeffrey.dsalgo.datastructures.queue;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StaticArrayQueue<T> implements Queue<T> {
    private Object[] array;
    private int head = -1;
    private int tail = -1;

    public StaticArrayQueue(int size) {
        this.array = new Object[size];
    }

    @Override
    public void enqueue(T data) {
     if (tail == array.length - 1) {
         throw new RuntimeException("Queue is Full");
     }
    if (isEmpty()) {
         head++;
     }

     array[++tail] = data;

    }

    @Override
    public T dequeue() {
        T data;
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        } else if (head == tail) {
            data = (T) array[head];
            tail = -1;
            head = -1;

        } else {
          data = (T) array[head++];
        }

        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return (T) array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int tempHead = head;
            private int tempTail = tail;
            @Override
            public boolean hasNext() {
                return tempHead != -1 && tempTail != -1;
            }

            @Override
            public T next() {
                T data;
                if (tempTail == -1 && tempHead == -1) {
                    throw new NoSuchElementException();
                } else if (tempHead == tempTail) {
                    data = (T) array[tempHead];
                    tempTail = -1;
                    tempHead = -1;
                } else {
                    data = (T) array[tempHead++];
                }
                return data;
            }
        };
    }
}
