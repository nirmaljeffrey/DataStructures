package dev.nirmaljeffrey.dsalgo.datastructures.queue;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayQueue<T> implements Queue<T> {
    private Object[] array;
    private int head = -1;
    private int tail = -1;

    public CircularArrayQueue(int size) {
        array = new Object[size];
    }

    @Override
    public void enqueue(T data) {
        if (isFull()) {
            throw  new RuntimeException("Queue is Full");
        }
       if (isEmpty()) {
          head = tail = 0;
       } else {
           tail = (tail + 1) % array.length;
       }
       array[tail] = data;
    }

    @Override
    public T dequeue() {
        T data;
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        } else if (tail == head) {
            data = (T) array[head];
            head = -1;
            tail = -1;
        } else {
            data = (T) array[head];
            head = (head + 1) % array.length;
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
        return tail == -1 && head == -1;
    }

    private boolean isFull() {
        return (tail + 1) % array.length == head;
    }
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
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
                } else if (tempTail == tempHead) {
                    data = (T) array[tempHead];
                    tempTail = -1;
                    tempTail = -1;
                } else {
                    data = (T) array[tempHead++];
                }
                return data;
            }
        };
    }
}
