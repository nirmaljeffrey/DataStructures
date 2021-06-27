package dev.nirmaljeffrey.dsalgo.datastructures.stack;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StackTest {

   private ArrayList<Stack<Integer>> stackList =  new ArrayList<>();

   @Before
    public void setUp() {
       stackList.add(new LinkedListStack<>());
       stackList.add(new StaticArrayStack<>(5));
       stackList.add(new DynamicArrayStack<>());
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

    @Test(expected = NoSuchElementException.class)
    public void testIteratorOnEmptyStack() {
       for (Stack<Integer> stack : stackList) {
           Iterator iterator = stack.iterator();
           assertFalse(iterator.hasNext());
           iterator.next();
       }
    }

    @Test
    public void testIteratorOneElementInStack() {
        for (Stack<Integer> stack : stackList) {
            stack.push(1);
            Iterator iterator = stack.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertFalse(iterator.hasNext());
        }
    }

    @Test
    public void testIteratorMultipleElementInStack() {
        for (Stack<Integer> stack : stackList) {
            stack.push(1);
            stack.push(2);
            Iterator iterator = stack.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(2, iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertFalse(iterator.hasNext());
        }
    }


    @After
    public void tearDown() {
            stackList = null;
   }

}
