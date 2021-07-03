package dev.nirmaljeffrey.dsalgo.datastructures.list;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class DoublyLinkedList<T> implements List<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;
    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void addLast(T data) {
        Node<T> temp = new Node<>(data, null, null);
        if (isEmpty()) {
            head = tail = temp;
        } else {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    @Override
    public void addFirst(T data) {
       Node<T> temp = new Node<>(data, null, null);
       if (isEmpty()) {
           head = tail = temp;
       } else {
           temp.next = head;
           head.prev = temp;
           head = temp;
       }
       size++;
    }

    @Override
    public void addAt(int index, T data) {
       if (index < 0 || index > size) {
           throw new IndexOutOfBoundsException();
       }
       if (index == 0) {
           addFirst(data);
           return;
       }
       if (index == size) {
           addLast(data);
           return;
       }
       Node<T> trav = head;
       for (int i = 0; i < index; i++) {
          trav = trav.getNext();
       }
        Node<T> temp = trav.prev;
        Node<T>  newNode = new Node<>(data, trav, temp);
       temp.next = newNode;
       trav.prev = newNode;
       size++;

    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        T data = head.data;
        if (tail == head) {
            tail.data = null;
            tail.next = tail.prev = null;
            head = tail = null;
        } else {
            Node<T> temp = head.next;
            temp.prev = null;
            head.data = null;
            head.prev = head.next = null;
            head = temp;
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");

        }
        T data = tail.data;
        if (tail == head) {
            tail.data = null;
            tail.next = tail.prev = null;
            head = tail = null;
        } else {
            Node<T> temp = tail.prev;
            temp.next = null;
            tail.data = null;
            tail.prev = tail.next = null;
            tail = temp;
        }
        size--;
        return data;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
           return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<T> trav = head;
        for (int i = 0; i < index; i++) {
            trav = trav.getNext();
        }
        T data = trav.data;
        Node<T> prevNode = trav.prev;
        Node<T> nextNode = trav.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        trav.prev = null;
        trav.data = null;
        trav.next =  null;
        size--;
        return data;
    }

    @Override
    public void clear() {
       if (!isEmpty()) {
           Node<T> trav = head;
           while (trav != null) {
               Node<T> temp = trav.next;
               trav.data = null;
               trav.prev = null;
               trav.next = null;
               trav = temp;
           }
           head = tail = null;
           size = 0;
       }
    }

    @Override
    public int indexOf(T element) {
       Node<T> trav = head;
       int i = 0;
       if (element == null) {
           while (trav != null) {
               if (trav.data == null) {
                   return i;
               }
               trav = trav.next;
               i++;
           }
       } else {
           while (trav != null) {
               if (element.equals(trav.data)) {
                   return i;
               }
               trav = trav.next;
               i++;
           }
       }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
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
    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");

        }
        return head.data;
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");

        }
        return tail.data;
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
                T data = tempHead.data;
                tempHead = tempHead.next;
                return data;
            }
        };
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
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

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
