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
        if (contains(element)) {
            root = remove(root, element);
            nodesCount--;
            return true;
        }
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

    private AvlTreeNode<T> remove(AvlTreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int comparatorValue = value.compareTo(node.value);

        if (comparatorValue > 0) {
            node.right = remove(node.right, value);
        } else if (comparatorValue < 0) {
            node.left = remove(node.left, value);
        } else {
            if (node.right == null) {
                AvlTreeNode<T> leftChild = node.left;
                node.value = null;
                node.left = node.right = null;
                node = null;
                return leftChild;
            } else if (node.left == null) {
                AvlTreeNode<T> rightChild = node.right;
                node.value = null;
                node.left = node.right = null;
                node = null;
                return rightChild;
            } else {
                if (node.left.height > node.right.height) {
                    AvlTreeNode<T> temp = digRightAndFindMax(node.left);
                    node.value = temp.value;
                    node.left = remove(node.left, temp.value);
                } else {
                    AvlTreeNode<T> temp = digLeftAndFindMin(node.right);
                    node.value = temp.value;
                    node.right = remove(node.right, temp.value);
                }
            }
        }
        updateBalanceFactorAndHeight(node);
        return balance(node);
    }


    private AvlTreeNode<T> digRightAndFindMax(AvlTreeNode<T> node) {
        AvlTreeNode<T> currentNode = node;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    private AvlTreeNode<T> digLeftAndFindMin(AvlTreeNode<T> node) {
        AvlTreeNode<T> currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
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
        // left heavy
        if (node.balanceFactor == -2) {
            if (node.left.balanceFactor <= 0) {
                return leftLeftCase(node);
            } else {
                return leftRightCase(node);
            }
        // right heavy
        } else if (node.balanceFactor == 2) {
            if (node.right.balanceFactor >= 0) {
                return rightRightCase(node);
            } else {
                return rightLeftCase(node);
            }
        }
        return node;
    }

    private AvlTreeNode<T> leftRotation(AvlTreeNode<T> parent) {
       AvlTreeNode<T> newParent = parent.right;
       parent.right = newParent.left;
       newParent.left =  parent;
       // Since rotations are performed, update balannce factor and height
       updateBalanceFactorAndHeight(parent);
       updateBalanceFactorAndHeight(newParent);
       return newParent;
    }

    private AvlTreeNode<T> rightRotation(AvlTreeNode<T> parent) {
        AvlTreeNode<T> newParent = parent.left;
        parent.left = newParent.right;
        newParent.right = parent;
        // Since rotations are performed, update balannce factor and height
        updateBalanceFactorAndHeight(parent);
        updateBalanceFactorAndHeight(newParent);
        return newParent;
    }

    private AvlTreeNode<T> leftLeftCase(AvlTreeNode<T> nodeA) {
        return rightRotation(nodeA);
    }

    private AvlTreeNode<T> rightRightCase(AvlTreeNode<T> nodeA) {
        return leftRotation(nodeA);
    }

    private AvlTreeNode<T> leftRightCase(AvlTreeNode<T> nodeA) {
        nodeA.left = leftRotation(nodeA.left);
        return rightRotation(nodeA);
    }

    private AvlTreeNode<T> rightLeftCase(AvlTreeNode<T> nodeA) {
        nodeA.right = rightRotation(nodeA.right);
        return leftRotation(nodeA);
    }
}
