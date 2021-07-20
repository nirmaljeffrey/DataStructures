package dev.nirmaljeffrey.dsalgo.datastructures.list.dynamicarray;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private int size = 0;
    private int capacity = 0;
    private T[] array;


    public DynamicArray() {
        this(2);
    }

    public DynamicArray(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("InvalidInitialCapacity: "+ capacity);
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
       array[index] = element;
    }
    public void clear() {
      for (int i = 0; i < capacity; i++) {
          array[i] = null;
      }
      size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public void add(T element) {
        if (size + 1 == capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array =  newArray;
        }
        array[size++] = element;
    }

    public boolean remove(T element) {
     for (int i = 0; i < size; i++) {
         if (array[i].equals(element)) {
              removeAt(i);
              return true;
         }
     }
      return false;
    }
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T data = array[index];
        T[] newArray = (T[]) new Object[size - 1];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (index == i) {
              j--;
            } else {
                newArray[j] = array[i];
            }
        }
        array = newArray;
        capacity = --size;
       return data;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
           if(array[i].equals(element)) {
               return i;
           }
        }
      return -1;
    }
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }
}
