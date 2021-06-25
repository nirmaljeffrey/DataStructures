package dev.nirmaljeffrey.datastructures.stack;

import org.jetbrains.annotations.NotNull;

import java.util.EmptyStackException;
import java.util.Iterator;

public class IntStack<T> implements Stack<Integer> {

    private int[] array;
    private int top = -1;
    public IntStack(int size) {
        this.array = new int[size];
    }

    @Override
    public int size() {
        return top++;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(@NotNull Integer data) {
        if (top == array.length - 1) {
            throw new StackOverflowError();
        }
       array[++top] = data;
    }

    @Override
    public Integer pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        Integer data = array[top];
        top--;
        return data;
    }

    @Override
    public Integer peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int temp = top;
            @Override
            public boolean hasNext() {
                return temp != -1;
            }

            @Override
            public Integer next() {
                return array[temp--];
            }
        };
    }
}
