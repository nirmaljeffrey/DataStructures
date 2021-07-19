package dev.nirmaljeffrey.dsalgo.algorithms.treetraversals;

import dev.nirmaljeffrey.dsalgo.common.TreePrinter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static <T extends Comparable<T>> void recursiveTraversal(ArrayList<T> arrayList, TreePrinter.PrintableNode<T> rootNode) {
        int height = getHeightOfTree(rootNode);
        for (int i = 0; i <= height; i++) {
           recursiveLevelOrderTraversal(arrayList, rootNode, i);
        }
    }

    private static <T extends Comparable<T>> void recursiveLevelOrderTraversal(ArrayList<T> arrayList, TreePrinter.PrintableNode<T> rootNode, int level) {
        if (rootNode == null) {
            return;
        }
        if (level == 0) {
            arrayList.add(rootNode.getData());
        } else {
            recursiveLevelOrderTraversal(arrayList, rootNode.getLeft(), level - 1);
            recursiveLevelOrderTraversal(arrayList, rootNode.getRight(), level - 1);
        }
    }

    private static <T extends Comparable<T>> int getHeightOfTree(TreePrinter.PrintableNode<T> rootNode) {
        if (rootNode == null) {
            return -1;
        }
        return Math.max(getHeightOfTree(rootNode.getLeft()), getHeightOfTree(rootNode.getRight())) + 1;
    }

    public static <T extends Comparable<T>> void iterativeTraversal(ArrayList<T> arrayList, TreePrinter.PrintableNode<T> rootNode) {
        Queue<TreePrinter.PrintableNode<T>> queue = new ArrayDeque<>();
        if (rootNode == null){
            return;
        }

        queue.add(rootNode);
        while (!queue.isEmpty()) {
            TreePrinter.PrintableNode<T> temp = queue.peek();
            arrayList.add(temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
            queue.poll();
        }


    }
}
