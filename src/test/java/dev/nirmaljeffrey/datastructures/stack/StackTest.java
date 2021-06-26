package dev.nirmaljeffrey.datastructures.stack;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {

   private ArrayList<Stack<Integer>> stackList =  new ArrayList<>();

   @Before
    public void setUp() {
       stackList.add(new LinkedListStack<>());
       stackList.add(new IntStack<>(5));
   }

   @Test
    public void testEmptyStack() {
       for (Stack<Integer> stack: stackList) {
           assertTrue(stack.isEmpty());
           assertEquals(stack.size(), 0);
       }
   }

    @Test(expected = EmptyStackException.class)
    public void testPopOnEmptyStack() {
        for (Stack<Integer> stack: stackList) {
            stack.pop();
        }
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekOnEmptyStack() {
        for (Stack<Integer> stack: stackList) {
            stack.peek();
        }
    }

    @Test
    public void testPush() {
        for (Stack<Integer> stack: stackList) {
            stack.push(1);
            assertEquals(stack.size(), 1);
            assertFalse(stack.isEmpty());
        }
    }

    @Test
    public void testPop() {
        for (Stack<Integer> stack: stackList) {
            stack.push(1);
            assertEquals(1, (int) stack.pop());
            assertEquals(stack.size(), 0);
            assertTrue(stack.isEmpty());
        }
    }



    @Test
    public void testPeek() {
        for (Stack<Integer> stack: stackList) {
            stack.push(1);
            assertEquals(1, (int) stack.peek());
            assertEquals(stack.size(), 1);
            assertFalse(stack.isEmpty());
        }
    }

    @Test
    public void testExhaustively() {
        for (Stack<Integer> stack: stackList) {
            assertTrue(stack.isEmpty());
            stack.push(1);
            assertFalse(stack.isEmpty());
            assertEquals(stack.size(), 1);
            stack.push(2);
            assertFalse(stack.isEmpty());
            assertEquals(stack.size(), 2);
            assertEquals(2, (int) stack.peek());
            assertFalse(stack.isEmpty());
            assertEquals(stack.size(), 2);
            assertEquals(2, (int) stack.pop());
            assertFalse(stack.isEmpty());
            assertEquals(stack.size(), 1);
            assertEquals(1, (int) stack.pop());
            assertTrue(stack.isEmpty());
            assertEquals(stack.size(), 0);
        }
    }


    @After
    public void tearDown() {
            stackList = null;
   }

}
