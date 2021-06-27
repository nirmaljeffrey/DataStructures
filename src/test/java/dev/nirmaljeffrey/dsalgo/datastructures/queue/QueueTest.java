package dev.nirmaljeffrey.dsalgo.datastructures.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueueTest {
    private ArrayList<Queue<Integer>> queueList =  new ArrayList<>();

    @Before
    public void setUp() {
        queueList.add(new LinkedListQueue<>());
    }


    @Test
    public void testEmptyQueue() {
        for (Queue<Integer> queue: queueList) {
            assertTrue(queue.isEmpty());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueOnEmptyQueue() {
        for (Queue<Integer> queue: queueList) {
              queue.dequeue();
        }
    }

    @Test(expected = NoSuchElementException.class)
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


    @After
    public void tearDown() {
        queueList = null;
    }

}
