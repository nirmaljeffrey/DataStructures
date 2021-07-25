package dev.nirmaljeffrey.dsalgo.datastructures.tree.trie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    private ArrayList<Trie> tries;
    @Before
    public void setup() {
        tries = new ArrayList<>();
        tries.add(new RecursiveTrie());
        tries.add(new IterativeTrie());
    }

    @Test
    public void testEmptyTrie() {
        for (Trie trie : tries) {
            assertTrue(trie.isEmpty());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTrieInsertNull() {
        for (Trie trie : tries) {
            trie.insert(null);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTrieInsertEmptyString() {
        for (Trie trie : tries) {
            trie.insert("");
        }
    }

    @Test
    public void testTrieStartsWithNull() {
        for (Trie trie : tries) {
            assertFalse(trie.startsWith(null));
        }
    }

    @Test
    public void testTrieStartsWithEmptyString() {
        for (Trie trie : tries) {
            assertFalse(trie.startsWith(""));
        }
    }

    @Test
    public void testTrieSearchNull() {
        for (Trie trie : tries) {
            assertFalse(trie.search(null));
        }
    }

    @Test
    public void testTrieSearchEmptyString() {
        for (Trie trie : tries) {
            assertFalse(trie.search(""));
        }
    }


    @Test
    public void testTrieInsert() {
        for (Trie trie : tries) {
            assertTrue(trie.isEmpty());
            trie.insert("arrow");
            assertFalse(trie.isEmpty());
            trie.insert("hello");
            assertFalse(trie.isEmpty());
        }
    }


    @Test
    public void testTrieSearch() {
        for (Trie trie : tries) {
            assertTrue(trie.isEmpty());
            trie.insert("arrow");
            trie.insert("are");
            trie.insert("armenia");

            assertFalse(trie.isEmpty());

            assertTrue(trie.search("arrow"));
            assertTrue(trie.search("are"));
            assertTrue(trie.search("armenia"));
            assertFalse(trie.search("a"));
            assertFalse(trie.search("ar"));
            assertFalse(trie.search("arro"));
            assertFalse(trie.search("hello"));
            assertFalse(trie.search("armeni"));
            assertFalse(trie.search("ARMENIA"));
            assertFalse(trie.search("ArmenIA"));
        }
    }

    @Test
    public void testTrieStartsWith() {
        for (Trie trie : tries) {
            assertTrue(trie.isEmpty());
            trie.insert("arrow");
            trie.insert("are");
            trie.insert("armenia");

            assertFalse(trie.isEmpty());

            assertTrue(trie.startsWith("arrow"));
            assertTrue(trie.startsWith("are"));
            assertTrue(trie.startsWith("armenia"));
            assertTrue(trie.startsWith("a"));
            assertTrue(trie.startsWith("ar"));
            assertTrue(trie.startsWith("arro"));
            assertTrue(trie.startsWith("armeni"));
            assertFalse(trie.startsWith("hello"));
            assertFalse(trie.startsWith("ARMENIA"));
            assertFalse(trie.startsWith("ArmenIA"));
        }
    }


    @After
    public void tearDown() {
        tries = null;
    }


}
