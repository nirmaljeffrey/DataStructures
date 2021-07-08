package dev.nirmaljeffrey.dsalgo.algorithms.treetraversals;

import dev.nirmaljeffrey.dsalgo.common.BinaryTreeNode;

import java.util.ArrayList;

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
      //TODO
    }
}
