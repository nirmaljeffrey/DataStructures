package dev.nirmaljeffrey.dsalgo.datastructures.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueueTest {
    private ArrayList<Queue<Integer>> queueList =  new ArrayList<>();

    @Before
    public void setUp() {
        queueList.add(new LinkedListQueue<>());
        queueList.add(new StaticArrayQueue<>(10));
        queueList.add(new DynamicArrayQueue<>());
        queueList.add(new CircularArrayQueue<>(10));
    }


    @Test
    public void testEmptyQueue() {
        for (Queue<Integer> queue: queueList) {
            assertTrue(queue.isEmpty());
        }
    }

    @Test(expected = RuntimeException.class)
    public void testDequeueOnEmptyQueue() {
        for (Queue<Integer> queue: queueList) {
              queue.dequeue();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testPeekOnEmptyQueue() {
        for (Queue<Integer> queue: queueList) {
            queue.dequeue();
        }
    }

    @Test
    public void testEnqueue() {
        for (Queue<Integer> queue: queueList) {
            queue.enqueue(1);
            assertFalse(queue.isEmpty());
        }
    }

    @Test
    public void testDequeue() {
        for (Queue<Integer> queue: queueList) {
            queue.enqueue(1);
            assertFalse(queue.isEmpty());
            assertEquals(1, (int) queue.dequeue());
            assertTrue(queue.isEmpty());
        }
    }

    @Test
    public void testPeek() {
        for (Queue<Integer> queue: queueList) {
            queue.enqueue(1);
            assertFalse(queue.isEmpty());
            assertEquals(1, (int) queue.peek());
            assertFalse(queue.isEmpty());
        }
    }

    @Test
    public void testExhaustively() {
        for (Queue<Integer> queue: queueList) {
            assertTrue(queue.isEmpty());
            queue.enqueue(1);
            assertFalse(queue.isEmpty());
            assertEquals(1, (int) queue.dequeue());
            assertTrue(queue.isEmpty());
            queue.enqueue(2);
            assertEquals(2, (int) queue.peek());
            assertFalse(queue.isEmpty());
            queue.enqueue(3);
            assertFalse(queue.isEmpty());
            assertEquals(2, (int) queue.dequeue());
            assertEquals(3, (int) queue.dequeue());
            assertTrue(queue.isEmpty());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorOnEmptyQueue() {
        for (Queue<Integer> queue : queueList) {
            Iterator iterator = queue.iterator();
            assertFalse(iterator.hasNext());
            iterator.next();
        }
    }

    @Test
    public void testIteratorOneElementInQueue() {
        for (Queue<Integer> queue : queueList) {
            queue.enqueue(1);
            Iterator iterator = queue.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertFalse(iterator.hasNext());
        }
    }
    @Test
    public void testIteratorMultipleElementInQueue() {
        for (Queue<Integer> queue : queueList) {
            queue.enqueue(1);
            queue.enqueue(2);
            Iterator iterator = queue.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(2, iterator.next());
            assertFalse(iterator.hasNext());
        }
    }


    @After
    public void tearDown() {
        queueList = null;
    }

}
