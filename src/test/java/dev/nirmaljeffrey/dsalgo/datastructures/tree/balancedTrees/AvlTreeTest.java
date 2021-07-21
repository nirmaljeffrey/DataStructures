package dev.nirmaljeffrey.dsalgo.datastructures.tree.balancedTrees;

import dev.nirmaljeffrey.dsalgo.common.TestingUtils;
import dev.nirmaljeffrey.dsalgo.common.TreeTraversalOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class AvlTreeTest {
    private AvlTree<Integer> avlTree;


    @Before
    public void setUp() {
        avlTree = new AvlTree<>();
    }

    @Test
    public void testEmptyAvlTree() {
        assertTrue(avlTree.isEmpty());
        assertEquals(0, avlTree.size());
    }

    @Test
    public void testAdd() {
        assertTrue(avlTree.add(6));
        // try to add duplicate elements
        assertFalse(avlTree.add(6));
        assertTrue(avlTree.add(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, avlTree.size());
        assertTrue(avlTree.add(6));
        assertEquals(1, avlTree.size());
        assertTrue(avlTree.add(2));
        assertEquals(2, avlTree.size());
    }


    @Test
    public void testAddingNullValues() {
        assertFalse(avlTree.add(null));
    }

    @Test
    public void testRemovingNullValues() {
        assertFalse(avlTree.add(null));
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

        assertEquals(-1, avlTree.height());
        assertTrue(avlTree.add(16));
        // level 0
        assertEquals(0, avlTree.height());
        // level 1
        assertTrue(avlTree.add(8));
        assertEquals(1, avlTree.height());
        // level 1
        assertTrue(avlTree.add(18));
        assertEquals(1, avlTree.height());
        // level 2
        assertTrue(avlTree.add(5));
        assertEquals(2, avlTree.height());
        // level 2
        assertTrue(avlTree.add(9));
        assertEquals(2, avlTree.height());
        // level 2
        assertTrue(avlTree.add(17));
        assertEquals(2, avlTree.height());
        // level 2
        assertTrue(avlTree.add(22));
        assertEquals(2, avlTree.height());
        // level 3
        assertTrue(avlTree.add(2));
        assertEquals(3, avlTree.height());
    }

    @Test
    public void testContains() {
        assertFalse(avlTree.contains(5));
        avlTree.add(5);
        assertTrue(avlTree.contains(5));
        avlTree.add(10);
        avlTree.add(3);
        avlTree.add(9);
        assertTrue(avlTree.contains(10));
        assertTrue(avlTree.contains(9));
        assertTrue(avlTree.contains(3));
        // Try looking for an element which doesn't exist in the tree
        assertFalse(avlTree.contains(2));

    }

    @Test
    public void testRemove() {
        // Try removing an element which doesn't exists
        assertEquals(0, avlTree.size());
        assertFalse(avlTree.remove(5));
        avlTree.add(5);
        assertEquals(1, avlTree.size());
        // Try removing an element which exists
        avlTree.add(6);
        assertEquals(2, avlTree.size());
        assertTrue(avlTree.remove(6));
        assertEquals(1, avlTree.size());
        // Try removing the root
        assertTrue(avlTree.remove(5));
        assertEquals(0, avlTree.size());
    }

    @Test
    public void testLeftLeftCase() {
        avlTree.add(3);
        avlTree.add(2);
        avlTree.add(1);

        assertEquals(2, avlTree.root.data.intValue());
        assertEquals(3, avlTree.root.right.data.intValue());
        assertEquals(1, avlTree.root.left.data.intValue());
    }

    @Test
    public void testLeftRightCase() {
        avlTree.add(3);
        avlTree.add(1);
        avlTree.add(2);

        assertEquals(2, avlTree.root.data.intValue());
        assertEquals(3, avlTree.root.right.data.intValue());
        assertEquals(1, avlTree.root.left.data.intValue());
    }

    @Test
    public void testRightRightCase() {
        avlTree.add(1);
        avlTree.add(2);
        avlTree.add(3);

        assertEquals(2, avlTree.root.data.intValue());
        assertEquals(3, avlTree.root.right.data.intValue());
        assertEquals(1, avlTree.root.left.data.intValue());
    }

    @Test
    public void testRightLeftCase() {
        avlTree.add(1);
        avlTree.add(3);
        avlTree.add(2);

        assertEquals(2, avlTree.root.data.intValue());
        assertEquals(3, avlTree.root.right.data.intValue());
        assertEquals(1, avlTree.root.left.data.intValue());
    }

    @Test
    public void addNodesInIncreasingOrderAndValidateBalanceFactorValues() {
        avlTree.add(2);
        avlTree.add(5);
        avlTree.add(8);
        avlTree.add(9);
        avlTree.add(16);
        avlTree.add(17);
        avlTree.add(18);
        avlTree.add(22);
        System.out.println(avlTree.toString());
        assertTrue(avlTree.validateBalanceFactorValues(avlTree.root));
    }

    @Test
    public void addNodesInIncreasingOrderAndValidateBstInvariant() {
        avlTree.add(2);
        avlTree.add(5);
        avlTree.add(8);
        avlTree.add(9);
        avlTree.add(16);
        avlTree.add(17);
        avlTree.add(18);
        avlTree.add(22);
        System.out.println(avlTree.toString());
       assertTrue(TestingUtils.validateBinarySearchTreeInvariant(avlTree.root));
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorHasNextOnEmptyAvlTree() {
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.IN_ORDER, true);
        iterator.hasNext();
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextOnEmptyAvlTree() {
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.IN_ORDER, true);
        iterator.next();
    }

    @Test
    public void testIteratorForPreOrderTraversalRecursively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.PRE_ORDER, true);
        int[] preOrderResultArray = TestingUtils.getPreOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(preOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForPreOrderTraversalIteratively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.PRE_ORDER, false);
        int[] preOrderResultArray = TestingUtils.getPreOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(preOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForInOrderTraversalRecursively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.IN_ORDER, true);
        int[] inOrderResultArray = TestingUtils.getInOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(inOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForInOrderTraversalIteratively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.IN_ORDER, false);
        int[] inOrderResultArray = TestingUtils.getInOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(inOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForPostOrderTraversalRecursively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.POST_ORDER, true);
        int[] postOrderResultArray = TestingUtils.getPostOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(postOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForPostOrderTraversalIteratively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.POST_ORDER, false);
        int[] postOrderResultArray = TestingUtils.getPostOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(postOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForLevelOrderTraversalRecursively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.LEVEL_ORDER, true);
        int[] levelOrderResultArray = TestingUtils.getLevelOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(levelOrderResultArray[index++], (int) iterator.next());
        }
    }

    @Test
    public void testIteratorForLevelOrderTraversalIteratively() {
        addNodesInTreeForTesting();
        Iterator<Integer> iterator = avlTree.iterator(TreeTraversalOrder.LEVEL_ORDER, false);
        int[] levelOrderResultArray = TestingUtils.getLevelOrderResultArray();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(levelOrderResultArray[index++], (int) iterator.next());
        }
    }

    @After
    public void tearDown() {
        avlTree = null;
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
        avlTree.add(16);
        // level 1
        avlTree.add(8);
        avlTree.add(18);
        // level 2
        avlTree.add(5);
        avlTree.add(9);
        avlTree.add(17);
        avlTree.add(22);
        // level 3
        avlTree.add(2);
    }
}
