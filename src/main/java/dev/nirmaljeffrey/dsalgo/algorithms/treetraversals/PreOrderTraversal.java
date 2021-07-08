package dev.nirmaljeffrey.dsalgo.algorithms.treetraversals;

import dev.nirmaljeffrey.dsalgo.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    public static <T> void recursiveTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode) {
        if (rootNode == null){
            return;
        }
        arrayList.add(rootNode.data);
        recursiveTraversal(arrayList, rootNode.left);
        recursiveTraversal(arrayList,rootNode.right);
    }

    public static <T> void iterativeTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> currentNode = rootNode;
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                arrayList.add(currentNode.data);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
    }
}
