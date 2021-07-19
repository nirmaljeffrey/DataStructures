package dev.nirmaljeffrey.dsalgo.datastructures.tree.balancedTrees;

import dev.nirmaljeffrey.dsalgo.common.AvlTreeNode;
import dev.nirmaljeffrey.dsalgo.datastructures.tree.Tree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private AvlTreeNode<T> root;
    private int nodesCount;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height() {
        return (root == null)? 0 : root.height;
    }

    @Override
    public int size() {
        return nodesCount;
    }

    @Override
    public boolean add(T element) {
        if (null == element) {
            return false;
        }
        if (contains(element)) {
            return false;
        }
        root = addNode(root, element);
        nodesCount++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    private AvlTreeNode<T> addNode(AvlTreeNode<T> node, T value) {
        if (node == null) {
            return new AvlTreeNode<>(value);
        }
        int comparatorValue = value.compareTo(node.value);
        if (comparatorValue > 0) {
            node.right = addNode(node.right, value);
        } else {
            node.left = addNode(node.left, value);
        }

        updateBalanceFactorAndHeight(node);

        return balance(node);
    }

    private boolean contains(AvlTreeNode<T> node, T value) {
        if (node == null || null == value) {
            return false;
        }
        int comparatorValue = value.compareTo(node.value);
        if (comparatorValue > 0) {
            return contains(node.right, value);
        } else if (comparatorValue < 0) {
            return contains(node.left, value);
        } else {
            return true;
        }
    }

    private void updateBalanceFactorAndHeight(AvlTreeNode<T> node) {
        int leftTreeHeight = -1;
        int rightTreeHeight = -1;
        if (node.right != null) {
            rightTreeHeight = node.right.height;
        }
        if (node.left != null) {
            leftTreeHeight = node.left.height;
        }
        node.height = Math.max(leftTreeHeight, rightTreeHeight) + 1;
        // BF = RH - LH
        node.balanceFactor = rightTreeHeight - leftTreeHeight;
    }

    private AvlTreeNode<T> balance(AvlTreeNode<T> node) {
        if (node.balanceFactor == -2) {

        } else if (node.balanceFactor == +2) {

        }
        return node;
    }

    private void leftRotation(AvlTreeNode<T> node) {

    }

    private void rightRotation(AvlTreeNode<T> node) {

    }
}
