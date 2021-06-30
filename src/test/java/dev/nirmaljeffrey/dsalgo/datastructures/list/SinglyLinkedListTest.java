package dev.nirmaljeffrey.dsalgo.datastructures.list;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    private ArrayList<List<Integer>> lists = new ArrayList<>();

    @Before
    public void setUp() {
        lists.add(new SinglyLinkedList<>());
    }

    @Test
    public void testEmptyList() {
        for (List<Integer> list : lists) {
            assertTrue(list.isEmpty());
            assertEquals(0, list.size());
        }
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveFirstOnEmptyList() {
        for (List<Integer> list : lists) {
            list.removeFirst();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveLastOnEmptyList() {
        for (List<Integer> list : lists) {
            list.removeLast();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testPeekFirstOnEmptyList() {
        for (List<Integer> list : lists) {
            list.peekFirst();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testPeekLastOnEmptyList() {
        for (List<Integer> list : lists) {
            list.peekLast();
        }
    }

    @Test
    public void testAddFirst() {
        for (List<Integer> list : lists) {
            assertTrue(list.isEmpty());
            list.addFirst(1);
            assertFalse(list.isEmpty());
            assertEquals(1, list.size());
            list.addFirst(2);
            assertFalse(list.isEmpty());
            assertEquals(2, list.size());
        }
    }

    @Test
    public void testAddLast() {
        for (List<Integer> list : lists) {
            assertTrue(list.isEmpty());
            list.addLast(1);
            assertFalse(list.isEmpty());
            assertEquals(1, list.size());
            list.addLast(2);
            assertFalse(list.isEmpty());
            assertEquals(2, list.size());
        }
    }

    @Test
    public void testAddAt() {
        for (List<Integer> list : lists) {

            assertTrue(list.isEmpty());
            list.addAt(0, 5);
            assertFalse(list.isEmpty());
            assertEquals(1, list.size());
            list.addAt(1, 10);
            assertFalse(list.isEmpty());
            assertEquals(2, list.size());
            list.addAt(2, 15);
            assertFalse(list.isEmpty());
            assertEquals(3, list.size());
        }
    }

    @Test
    public void testRemoveFirst() {
        for (List<Integer> list : lists) {
            assertTrue(list.isEmpty());
            list.addFirst(1);
            assertFalse(list.isEmpty());
            assertEquals(1, list.size());
            assertEquals(1, (int) list.removeFirst());
            assertTrue(list.isEmpty());
        }
    }

    @Test
    public void testRemoveLast() {
        for (List<Integer> list : lists) {
            assertTrue(list.isEmpty());
            list.addFirst(1);
            assertFalse(list.isEmpty());
            assertEquals(1, list.size());
            assertEquals(1, (int) list.removeLast());
            assertTrue(list.isEmpty());
            list.addFirst(2);
            list.addFirst(3);
            assertFalse(list.isEmpty());
            assertEquals(2, (int) list.removeLast());
            assertEquals(1, list.size());
        }
    }

    @Test
    public void testPeeking() {
        for (List<Integer> list : lists) {
            assertTrue(list.isEmpty());
            // 7
            list.add(7);
            assertFalse(list.isEmpty());
            assertEquals(7, (int) list.peekFirst());
            assertEquals(7, (int) list.peekLast());
            // 7 - 8
            list.add(8);
            assertFalse(list.isEmpty());
            assertEquals(7, (int) list.peekFirst());
            assertEquals(8, (int) list.peekLast());
            // 7 - 8 - 9
            list.add(9);
            assertFalse(list.isEmpty());
            assertEquals(7, (int) list.peekFirst());
            assertEquals(9, (int) list.peekLast());
            // 7 - 8
            list.removeLast();
            assertFalse(list.isEmpty());
            assertEquals(7, (int) list.peekFirst());
            assertEquals(8, (int) list.peekLast());
            // 8
            list.removeFirst();
            assertFalse(list.isEmpty());
            assertEquals(8, (int) list.peekFirst());
            assertEquals(8, (int) list.peekLast());
        }
    }

    @Test
    public void testRemoving() {
        for (List<Integer> list : lists) {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.removeLast();
            list.removeFirst();
            list.removeLast();
            list.removeFirst();
            list.removeLast();
            assertEquals(0, list.size());
            assertTrue(list.isEmpty());
        }
    }

    @Test
    public void testRemoveAt() {
        for (List<Integer> list : lists) {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            assertEquals(2, (int) list.removeAt(1));
            assertEquals(4, list.size());
            assertEquals(3, (int) list.removeAt(1));
            assertEquals(3, list.size());
            assertEquals(1, (int) list.removeAt(0));
            assertEquals(2, list.size());
        }
    }


    @Test
    public void testContains(){
        for (List<Integer> list : lists) {
            list.add(1);
            assertTrue(list.contains(1));
            list.removeFirst();
            assertFalse(list.contains(1));
        }
    }

    @Test
    public void testIndexOf() {
        for (List<Integer> list : lists) {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            assertEquals(0, list.indexOf(1));
            assertEquals(1, list.indexOf(2));
            list.removeFirst();
            assertEquals(0, list.indexOf(2));
        }
    }


    @Test
    public void testIteratorOneElementInQueue() {
        for (List<Integer> list : lists) {
            list.add(1);
            Iterator iterator = list.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertFalse(iterator.hasNext());
        }
    }
    @Test
    public void testIteratorMultipleElementInQueue() {
        for (List<Integer> list : lists) {
            list.add(1);
            list.add(2);
            Iterator iterator = list.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(2, iterator.next());
            assertFalse(iterator.hasNext());
        }
    }

    @After
    public void tearDown() {
        lists = null;
    }
}
