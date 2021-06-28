package dev.nirmaljeffrey.dsalgo.datastructures.queue;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayQueue<T> implements Queue<T> {
    private Object[] array;
    private int head = -1;
    private int tail = -1;
    public DynamicArrayQueue() {
        array = new Object[16];
    }

    @Override
    public void enqueue(T data) {
        if (tail == array.length - 1) {
            increaseCapacity();
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
            throw new NoSuchElementException();
        } else if (tail == head) {
           data = (T) array[head];
           head = -1;
           tail = -1;
        } else {
            data = (T) array[head++];
        }
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == -1 & tail == -1;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int tempHead = head;
            private int tempTail = tail;
            @Override
            public boolean hasNext() {
                return tempTail != -1 && tempHead != -1;
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

    private void increaseCapacity() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
