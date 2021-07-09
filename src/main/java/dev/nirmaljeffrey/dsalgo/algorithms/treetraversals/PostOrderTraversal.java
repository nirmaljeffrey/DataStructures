package dev.nirmaljeffrey.dsalgo.algorithms.treetraversals;

import dev.nirmaljeffrey.dsalgo.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

    public static <T> void recursiveTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode) {
        if (rootNode == null){
            return;
        }
        recursiveTraversal(arrayList, rootNode.left);
        recursiveTraversal(arrayList,rootNode.right);
        arrayList.add(rootNode.data);
    }

    public static <T> void iterativeTraversal(ArrayList<T> arrayList, BinaryTreeNode<T> rootNode) {
      BinaryTreeNode<T> currentNode = rootNode;
      Stack<BinaryTreeNode<T>> stack = new Stack<>();
      while (currentNode != null || !stack.isEmpty()) {
          if (currentNode != null) {
              stack.push(currentNode);
              currentNode = currentNode.left;
          } else {
              BinaryTreeNode<T> temp = stack.peek().right;
              if (temp == null) {
                temp = stack.pop();
                arrayList.add(temp.data);
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    arrayList.add(temp.data);
                }
              } else {
                  currentNode = temp;
              }
          }
        }
    }
}
