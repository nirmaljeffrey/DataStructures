package dev.nirmaljeffrey.dsalgo.datastructures.stack;

import org.jetbrains.annotations.NotNull;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StaticArrayStack<T> implements Stack<T> {

    private Object[] array;
    private int top = -1;
    public StaticArrayStack(int size) {
        this.array = new Object[size];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(T data) {
        if (top == array.length) {
            throw new StackOverflowError();
        }
       array[++top] = data;
    }

    @Override
    public T pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        T data = (T) array[top];
        --top;
        return data;
    }

    @Override
    public T peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return (T) array[top];
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return new Iterator<>() {
            private int temp = top;
            @Override
            public boolean hasNext() {
                return temp != -1;
            }

            @Override
            public T next() {
                if (temp == -1) {
                    throw new NoSuchElementException();
                }
                return (T) array[temp--];
            }
        };
    }
}
