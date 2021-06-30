package dev.nirmaljeffrey.dsalgo.datastructures.list;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> singlyLinkedList;

    @Before
    public void setUp() {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testEmptyList() {
        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveFirstOnEmptyList() {
        singlyLinkedList.removeFirst();
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveLastOnEmptyList() {
        singlyLinkedList.removeLast();
    }

    @Test(expected = RuntimeException.class)
    public void testPeekFirstOnEmptyList() {
        singlyLinkedList.peekFirst();
    }

    @Test(expected = RuntimeException.class)
    public void testPeekLastOnEmptyList() {
        singlyLinkedList.peekLast();
    }

    @Test
    public void testAddFirst() {
        assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.addFirst(1);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        singlyLinkedList.addFirst(2);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
    }

    @Test
    public void testAddLast() {
        assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.addLast(1);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        singlyLinkedList.addLast(2);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
    }

    @Test
    public void testAddAt() {
        assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.addAt(0,5);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        singlyLinkedList.addAt(1,10);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
        singlyLinkedList.addAt(2,15);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(3, singlyLinkedList.size());
    }

    @Test
    public void testRemoveFirst() {
        assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.addFirst(1);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        assertEquals(1, (int) singlyLinkedList.removeFirst());
        assertTrue(singlyLinkedList.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.addFirst(1);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        assertEquals(1, (int) singlyLinkedList.removeLast());
        assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, (int) singlyLinkedList.removeLast());
        assertEquals(1, singlyLinkedList.size());
    }

    @Test
    public void testPeeking() {
        assertTrue(singlyLinkedList.isEmpty());
        // 7
        singlyLinkedList.add(7);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(7, (int) singlyLinkedList.peekFirst());
        assertEquals(7, (int) singlyLinkedList.peekLast());
        // 7 - 8
        singlyLinkedList.add(8);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(7, (int) singlyLinkedList.peekFirst());
        assertEquals(8, (int) singlyLinkedList.peekLast());
        // 7 - 8 - 9
        singlyLinkedList.add(9);
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(7, (int) singlyLinkedList.peekFirst());
        assertEquals(9, (int) singlyLinkedList.peekLast());
        // 7 - 8
        singlyLinkedList.removeLast();
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(7, (int) singlyLinkedList.peekFirst());
        assertEquals(8, (int) singlyLinkedList.peekLast());
        // 8
        singlyLinkedList.removeFirst();
        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(8, (int) singlyLinkedList.peekFirst());
        assertEquals(8, (int) singlyLinkedList.peekLast());
    }

    @Test
    public void testRemoving() {
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        singlyLinkedList.removeLast();
        singlyLinkedList.removeFirst();
        singlyLinkedList.removeLast();
        singlyLinkedList.removeFirst();
        singlyLinkedList.removeLast();
        assertEquals(0, singlyLinkedList.size());
        assertTrue(singlyLinkedList.isEmpty());
    }

    @Test
    public void testRemoveAt() {
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        assertEquals(2, (int) singlyLinkedList.removeAt(1));
        assertEquals(4, singlyLinkedList.size());
        assertEquals(3, (int) singlyLinkedList.removeAt(1));
        assertEquals(3, singlyLinkedList.size());
        assertEquals(1, (int) singlyLinkedList.removeAt(0));
        assertEquals(2, singlyLinkedList.size());
    }


    @Test
    public void testContains(){
        singlyLinkedList.add(1);
        assertTrue(singlyLinkedList.contains(1));
        singlyLinkedList.removeFirst();
        assertFalse(singlyLinkedList.contains(1));
    }

    @Test
    public void testIndexOf(){
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        assertEquals(0,singlyLinkedList.indexOf(1));
        assertEquals(1, singlyLinkedList.indexOf(2));
        singlyLinkedList.removeFirst();
        assertEquals(0, singlyLinkedList.indexOf(2));
    }


    @Test
    public void testIteratorOneElementInQueue() {
            singlyLinkedList.add(1);
            Iterator iterator = singlyLinkedList.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertFalse(iterator.hasNext());
    }
    @Test
    public void testIteratorMultipleElementInQueue() {
            singlyLinkedList.add(1);
            singlyLinkedList.add(2);
            Iterator iterator = singlyLinkedList.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(2, iterator.next());
            assertFalse(iterator.hasNext());
    }

    @After
    public void tearDown() {
        singlyLinkedList = null;
    }
}
