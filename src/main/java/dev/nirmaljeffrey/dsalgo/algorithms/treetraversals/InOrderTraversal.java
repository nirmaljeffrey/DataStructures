package dev.nirmaljeffrey.dsalgo.algorithms.treetraversals;


import dev.nirmaljeffrey.dsalgo.common.TreePrinter;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
    public static <T extends Comparable<T>> void recursiveTraversal(ArrayList<T> arrayList, TreePrinter.PrintableNode<T> rootNode) {
        if (rootNode == null){
            return;
        }
        recursiveTraversal(arrayList, rootNode.getLeft());
        arrayList.add(rootNode.getData());
        recursiveTraversal(arrayList,rootNode.getRight());
    }

    public static <T extends Comparable<T>> void iterativeTraversal(ArrayList<T> arrayList, TreePrinter.PrintableNode<T> rootNode) {
        Stack<TreePrinter.PrintableNode<T>> stack = new Stack<>();
        TreePrinter.PrintableNode<T> currentNode = rootNode;
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            } else {
                currentNode = stack.pop();
                arrayList.add(currentNode.getData());
                currentNode = currentNode.getRight();
            }
        }
    }
}
