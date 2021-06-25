package dev.nirmaljeffrey.datastructures.stack;


import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> head = null;
    private int size = 0;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T data) {
      head = new Node<>(data,head);
      size++;
    }

    @Override
    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
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
