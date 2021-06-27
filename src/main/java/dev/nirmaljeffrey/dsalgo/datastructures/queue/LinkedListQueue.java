package dev.nirmaljeffrey.dsalgo.datastructures.queue;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void enqueue(T data) {
        Node<T> temp = new Node<>(data, null);
        if (isEmpty()) {
            head = temp;
            tail = temp;
        } else {
             tail.next = temp;
             tail = temp;
        }
    }

    @Override
    public T dequeue() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        Node<T> temp = head.next;
        if (head == tail) {
            tail = temp;
        }
        head = temp;
        return data;
    }

    @Override
    public T peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> tempHead = head;
            @Override
            public boolean hasNext() {
                return tempHead != null;
            }

            @Override
            public T next() {
                if (tempHead == null) {
                    throw new NoSuchElementException();
                }
                T data = tempHead.data;
                tempHead = tempHead.next;
                return data;
            }
        };
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
