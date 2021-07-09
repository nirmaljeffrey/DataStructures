package dev.nirmaljeffrey.dsalgo.algorithms.treetraversals;

import dev.nirmaljeffrey.dsalgo.common.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static <T> void recursiveTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode) {
        int height = getHeightOfTree(rootNode);
        for (int i = 0; i <= height; i++) {
           recursiveLevelOrderTraversal(arrayList, rootNode, i);
        }
    }

    private static <T> void recursiveLevelOrderTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode, int level) {
        if (rootNode == null) {
            return;
        }
        if (level == 0) {
            arrayList.add(rootNode.data);
        } else {
            recursiveLevelOrderTraversal(arrayList, rootNode.left, level - 1);
            recursiveLevelOrderTraversal(arrayList, rootNode.right, level - 1);
        }
    }

    private static <T> int getHeightOfTree(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return -1;
        }
        return Math.max(getHeightOfTree(rootNode.left), getHeightOfTree(rootNode.right)) + 1;
    }

    public static <T> void iterativeTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode) {
        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        if (rootNode == null){
            return;
        }

        queue.add(rootNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> temp = queue.peek();
            arrayList.add(temp.data);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            queue.poll();
        }


    }
}
