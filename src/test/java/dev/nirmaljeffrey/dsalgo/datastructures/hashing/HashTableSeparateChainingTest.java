package dev.nirmaljeffrey.dsalgo.datastructures.hashing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class HashTableSeparateChainingTest {
    private HashTableSeparateChaining<Integer, Integer> hashTable;

    @Before
    public void setup() {
        hashTable = new HashTableSeparateChaining<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalCreation1() {
        new HashTableSeparateChaining<>(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalCreation2() {
        new HashTableSeparateChaining<>(4, -0.5);
    }

    @Test
    public void testLegalCreation1() {
        new HashTableSeparateChaining<>(4, 0.5);
    }

    @Test
    public void testEmptyHashTable() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
    }

    @Test
    public void testUpsert() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        hashTable.insert(1,1);
        assertEquals(1, (int) hashTable.get(1));
        hashTable.insert(1, 5);
        assertEquals(5, (int) hashTable.get(1));
        hashTable.insert(2,6);
        assertEquals(6, (int) hashTable.get(2));

    }

    @Test
    public void testUpsertWithNullKey() {
        assertNull(hashTable.insert(null, 4));
    }

    @Test
    public void testRemoveOnEmptyHashTable() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        assertNull(hashTable.remove(1));
    }

    @Test
    public void testRemoveWithNullKey() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        assertNull(hashTable.remove(null));
        hashTable.insert(1,4);
        assertNull(hashTable.remove(null));
        assertFalse(hashTable.isEmpty());
        assertEquals(1, hashTable.size());
    }

    @Test
    public void testRemove() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        hashTable.insert(1,1);
        hashTable.insert(2,2);
        hashTable.insert(3,3);
        hashTable.insert(4,4);

        assertEquals(4, hashTable.size());

        assertEquals(4, (int) hashTable.remove(4));
        assertEquals(3, hashTable.size());
        assertNull(hashTable.remove(4));
        assertEquals(3, hashTable.size());
        assertEquals(3, (int) hashTable.remove(3));
        assertEquals(2, hashTable.size());
        assertEquals(2, (int) hashTable.remove(2));
        assertEquals(1, hashTable.size());
        assertEquals(1, (int) hashTable.remove(1));
        assertTrue(hashTable.isEmpty());
    }


    @Test
    public void testContainsOnEmptyHashTable() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());

        assertFalse(hashTable.containsKey(1));
    }

    @Test
    public void testContainsWithNullValues() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());

        assertFalse(hashTable.containsKey(null));
    }

    @Test
    public void testContains() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        hashTable.insert(1,1);
        hashTable.insert(2,2);
        hashTable.insert(3,3);
        hashTable.insert(4,4);

        assertEquals(4, hashTable.size());

        assertTrue(hashTable.containsKey(1));
        hashTable.remove(1);
        assertFalse(hashTable.containsKey(1));
        assertTrue(hashTable.containsKey(2));
        assertTrue(hashTable.containsKey(3));
        assertTrue(hashTable.containsKey(4));
    }


    @Test
    public void testClear() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        hashTable.insert(1,1);
        hashTable.insert(2,2);
        hashTable.insert(3,3);
        hashTable.insert(4,4);
        assertEquals(4, hashTable.size());

        hashTable.clear();


        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        assertFalse(hashTable.containsKey(1));
        assertFalse(hashTable.containsKey(2));
        assertFalse(hashTable.containsKey(3));
        assertFalse(hashTable.containsKey(4));
    }

    @Test
    public void testIteratorOneElementInQueue() {
            hashTable.insert(1, 1);
            Iterator<Integer> iterator = hashTable.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, (int) iterator.next());
            assertFalse(iterator.hasNext());
    }
    @Test
    public void testIteratorMultipleElementInQueue() {
            hashTable.insert(1, 1);
            hashTable.insert(2, 1);
            hashTable.insert(3, 2);
            Iterator<Integer> iterator = hashTable.iterator();
            assertTrue(iterator.hasNext());
            assertEquals(1, (int) iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(2, (int) iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(3, (int) iterator.next());
            assertFalse(iterator.hasNext());
    }

    @After
    public void tearDown() {
        hashTable = null;
    }
}
