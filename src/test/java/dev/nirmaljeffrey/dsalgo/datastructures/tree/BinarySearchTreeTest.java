package dev.nirmaljeffrey.dsalgo.datastructures.tree;

import dev.nirmaljeffrey.dsalgo.common.TreeTraversalOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
private BinarySearchTree<Integer> binarySearchTree;
    @Before
    public void setUp() {
      binarySearchTree = new BinarySearchTree<>();
    }

    @Test
    public void testEmptyBinarySearchTree() {
        assertTrue(binarySearchTree.isEmpty());
        assertEquals(0, binarySearchTree.size());
    }

    @Test
    public void testAdd() {
        assertTrue(binarySearchTree.add(6));
        // try to add duplicate elements
        assertFalse(binarySearchTree.add(6));
        assertTrue(binarySearchTree.add(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, binarySearchTree.size());
        assertTrue(binarySearchTree.add(6));
        assertEquals(1, binarySearchTree.size());
        assertTrue(binarySearchTree.add(2));
        assertEquals(2, binarySearchTree.size());
    }

    @Test
    public void testHeight() {
        // Tree should look like:
        //          16      --- level 0
        //        /   \
        //      8      18   --- level 1
        //     / \     / \
        //    5  9   17  22 --- level 2
        //   /
        //  2               --- level 3
        //
        // height of the tree = longest path from root node to leaf node (no. of edges)
        // height of the above tree = 3

        assertEquals(-1, binarySearchTree.height());
        assertTrue(binarySearchTree.add(16));
        // level 0
        assertEquals(0, binarySearchTree.height());
        // level 1
        assertTrue(binarySearchTree.add(8));
        assertEquals(1, binarySearchTree.height());
        // level 1
        assertTrue(binarySearchTree.add(18));
        assertEquals(1, binarySearchTree.height());
        // level 2
        assertTrue(binarySearchTree.add(5));
        assertEquals(2, binarySearchTree.height());
        // level 2
        assertTrue(binarySearchTree.add(9));
        assertEquals(2, binarySearchTree.height());
        // level 2
        assertTrue(binarySearchTree.add(17));
        assertEquals(2, binarySearchTree.height());
        // level 2
        assertTrue(binarySearchTree.add(22));
        assertEquals(2, binarySearchTree.height());
        // level 3
        assertTrue(binarySearchTree.add(2));
        assertEquals(3, binarySearchTree.height());
    }

    @Test
    public void testContains() {
        assertFalse(binarySearchTree.contains(5));
        binarySearchTree.add(5);
        assertTrue(binarySearchTree.contains(5));
        binarySearchTree.add(10);
        binarySearchTree.add(3);
        binarySearchTree.add(9);
        assertTrue(binarySearchTree.contains(10));
        assertTrue(binarySearchTree.contains(9));
        assertTrue(binarySearchTree.contains(3));
        // Try looking for an element which doesn't exist in the tree
        assertFalse(binarySearchTree.contains(2));

    }

    @Test
    public void testRemove() {
        // Try removing an element which doesn't exists
       assertEquals(0, binarySearchTree.size());
       assertFalse(binarySearchTree.remove(5));
       binarySearchTree.add(5);
       assertEquals(1, binarySearchTree.size());
       // Try removing an element which exists
       binarySearchTree.add(6);
        assertEquals(2, binarySearchTree.size());
        assertTrue(binarySearchTree.remove(6));
        assertEquals(1, binarySearchTree.size());
        // Try removing the root
        assertTrue(binarySearchTree.remove(5));
        assertEquals(0, binarySearchTree.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorHasNextOnEmptyBinarySearchTree() {
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.IN_ORDER, true);
        iterator.hasNext();
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextOnEmptyBinarySearchTree() {
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.IN_ORDER, true);
        iterator.next();
    }

    @Test
    public void testIteratorForPreOrderTraversalRecursively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.PRE_ORDER, true);
        int[] preOrderResultArray = getPreOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(preOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForPreOrderTraversalIteratively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.PRE_ORDER, false);
        int[] preOrderResultArray = getPreOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(preOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForInOrderTraversalRecursively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.IN_ORDER, true);
        int[] inOrderResultArray = getInOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(inOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForInOrderTraversalIteratively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.IN_ORDER, false);
        int[] inOrderResultArray = getInOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(inOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForPostOrderTraversalRecursively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.POST_ORDER, true);
        int[] postOrderResultArray = getPostOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(postOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForPostOrderTraversalIteratively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.POST_ORDER, false);
        int[] postOrderResultArray = getPostOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(postOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForLevelOrderTraversalRecursively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.LEVEL_ORDER, true);
        int[] levelOrderResultArray = getLevelOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(levelOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForLevelOrderTraversalIteratively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalOrder.LEVEL_ORDER, false);
        int[] levelOrderResultArray = getLevelOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(levelOrderResultArray[index++], (int) iterator.next());
        }
    }

    @After
    public void tearDown() {
      binarySearchTree = null;
    }

    private void addNodesInTreeForTesting() {
        // Tree should look like:
        //          16      --- level 0
        //        /   \
        //      8      18   --- level 1
        //     / \     / \
        //    5  9   17  22 --- level 2
        //   /
        //  2               --- level 3
        // level 0
        binarySearchTree.add(16);
        // level 1
        binarySearchTree.add(8);
        binarySearchTree.add(18);
        // level 2
        binarySearchTree.add(5);
        binarySearchTree.add(9);
        binarySearchTree.add(17);
        binarySearchTree.add(22);
        // level 3
        binarySearchTree.add(2);
    }

    private static int[] getPreOrderResultArray() {
        return new int[]{16, 8, 5, 2, 9, 18, 17, 22};
    }

    private static int[] getInOrderResultArray() {
        return new int[]{2, 5, 8, 9, 16, 17, 18, 22};
    }

    private static int[] getPostOrderResultArray() {
        return new int[]{2, 5, 9, 8, 17, 22, 18, 16};
    }

    private static int[] getLevelOrderResultArray() {
        return new int[]{16, 8, 18, 5, 9, 17, 22, 2};
    }
}
