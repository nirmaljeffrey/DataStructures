package dev.nirmaljeffrey.dsalgo.algorithms.treetraversals;


import dev.nirmaljeffrey.dsalgo.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
    public static <T> void recursiveTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode) {
        if (rootNode == null){
            return;
        }
        recursiveTraversal(arrayList, rootNode.left);
        arrayList.add(rootNode.data);
        recursiveTraversal(arrayList,rootNode.right);
    }

    public static <T> void iterativeTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> currentNode = rootNode;
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                arrayList.add(currentNode.data);
                currentNode = currentNode.right;
            }
        }
    }
}
