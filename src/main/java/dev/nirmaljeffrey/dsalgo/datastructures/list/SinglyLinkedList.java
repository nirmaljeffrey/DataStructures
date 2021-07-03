package dev.nirmaljeffrey.dsalgo.datastructures.list;


import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SinglyLinkedList<T> implements List<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void addLast(T data) {
        Node<T> temp = new Node<>(data, null);
        if(isEmpty()) {
            head = temp;
            tail = temp;
        } else {
          tail.setNext(temp);
          tail = temp;
        }
        size++;
    }

    @Override
    public void addFirst(T data) {
       Node<T> temp = new Node<>(data, null);
        if(isEmpty()) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head);
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
      Node<T> temp = head.getNext();
      for (int i = 1; i < index - 1; i++) {
          temp = temp.getNext();
      }
      Node<T> temp1 = new Node<>(data, temp.getNext());
      temp.setNext(temp1);
      size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        T data = head.getData();
        if (tail == head) {
            tail.setNext(null);
            tail.setData(null);
            tail = head = null;
        } else {
            Node<T> temp = head.getNext();
            head.setData(null);
            head.setNext(null);
            head = temp;
        }
        size--;
        if (isEmpty()) {
            head = tail = null;
        }
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        T data = tail.getData();
        if (tail == head) {
            tail.setNext(null);
            tail.setData(null);
            tail = head = null;
        } else {
            Node<T> firstIterator = head;
            Node<T> secondIterator = head.getNext();
            while (secondIterator != tail) {
                firstIterator = firstIterator.getNext();
                secondIterator = secondIterator.getNext();
            }
            tail = firstIterator;
            tail.setNext(null);
            secondIterator.setNext(null);
            secondIterator.setData(null);
        }
        size--;
        if (isEmpty()) {
            head = tail = null;
        }
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
        Node<T> firstIterator = head;
        Node<T> secondIterator = head.getNext();
        for (int i = 0; i < index - 1; i++) {
            firstIterator = firstIterator.getNext();
            secondIterator = secondIterator.getNext();
        }
        T data = secondIterator.getData();
        firstIterator.setNext(secondIterator.getNext());
        secondIterator.setNext(null);
        secondIterator.setData(null);
        size--;
        if (isEmpty()) {
            head = tail = null;
        }
        return data;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                Node<T> next = temp.getNext();
                temp.setNext(null);
                temp.setData(null);
                temp = next;
            }
            tail = head = null;
            size = 0;
        }
    }

        @Override
        public int indexOf(T element) {
        if (!isEmpty()) {
            int index = 0;
            Node<T> temp = head;
            if (element == null) {
                while(temp != null) {
                  if (temp.getData() == null) {
                      return index;
                  }
                  temp = temp.getNext();
                  index++;
                }
            } else {
               while (temp != null) {
                   if (element.equals(temp.getData())) {
                       return index;
                   }
                   temp = temp.getNext();
                   index++;
               }
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
            throw new RuntimeException("List is empty");
        }
        return head.getData();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return tail.getData();
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
                T data = tempHead.getData();
                tempHead = tempHead.getNext();
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
