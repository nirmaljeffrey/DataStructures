package dev.nirmaljeffrey.dsalgo.datastructures.list;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;

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

    @After
    public void tearDown() {
        singlyLinkedList = null;
    }
}
