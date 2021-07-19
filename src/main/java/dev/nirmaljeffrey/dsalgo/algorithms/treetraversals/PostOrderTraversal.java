package dev.nirmaljeffrey.dsalgo.algorithms.treetraversals;

import dev.nirmaljeffrey.dsalgo.common.TreePrinter;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

    public static <T extends Comparable<T>> void recursiveTraversal(ArrayList<T> arrayList, TreePrinter.PrintableNode<T> rootNode) {
        if (rootNode == null){
            return;
        }
        recursiveTraversal(arrayList, rootNode.getLeft());
        recursiveTraversal(arrayList,rootNode.getRight());
        arrayList.add(rootNode.getData());
    }

    public static <T extends Comparable<T>> void iterativeTraversal(ArrayList<T> arrayList, TreePrinter.PrintableNode<T> rootNode) {
      TreePrinter.PrintableNode<T> currentNode = rootNode;
      Stack<TreePrinter.PrintableNode<T>> stack = new Stack<>();
      while (currentNode != null || !stack.isEmpty()) {
          if (currentNode != null) {
              stack.push(currentNode);
              currentNode = currentNode.getLeft();
          } else {
              TreePrinter.PrintableNode<T> temp = stack.peek().getRight();
              if (temp == null) {
                temp = stack.pop();
                arrayList.add(temp.getData());
                while (!stack.isEmpty() && temp == stack.peek().getRight()) {
                    temp = stack.pop();
                    arrayList.add(temp.getData());
                }
              } else {
                  currentNode = temp;
              }
          }
        }
    }
}
