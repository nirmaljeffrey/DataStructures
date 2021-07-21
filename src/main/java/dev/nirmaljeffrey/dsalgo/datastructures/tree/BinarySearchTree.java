package dev.nirmaljeffrey.dsalgo.datastructures.tree;

import dev.nirmaljeffrey.dsalgo.algorithms.treetraversals.InOrderTraversal;
import dev.nirmaljeffrey.dsalgo.algorithms.treetraversals.LevelOrderTraversal;
import dev.nirmaljeffrey.dsalgo.algorithms.treetraversals.PostOrderTraversal;
import dev.nirmaljeffrey.dsalgo.algorithms.treetraversals.PreOrderTraversal;
import dev.nirmaljeffrey.dsalgo.common.BinaryTreeNode;
import dev.nirmaljeffrey.dsalgo.common.TreePrinter;
import dev.nirmaljeffrey.dsalgo.common.TreeTraversalOrder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private int nodeCount = 0;
    public BinaryTreeNode<T> rootNode;

    @Override
    public boolean isEmpty() {
        return nodeCount == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public boolean add(T element) {
     if(contains(element) || element == null) {
         return false;
     } else {
        rootNode = addNode(rootNode, element);
         nodeCount++;
         return true;
     }
    }

    private BinaryTreeNode<T> addNode(BinaryTreeNode<T> root, T element) {
        if (root == null) {
            root = new BinaryTreeNode<>(element);
        } else {
            int comparatorValue = element.compareTo(root.data);
            if (comparatorValue < 0) {
                root.left = addNode(root.left, element);
            } else if (comparatorValue > 0) {
                root.right = addNode(root.right, element);
            }
        }

        return root;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) {
            return false;
        }
        if (contains(element)) {
            rootNode = remove(rootNode, element);
            nodeCount--;
            return true;
        }
     return false;
    }
    private BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T element) {
        if (node == null) {
            return null;
        }
        int comparatorValue = node.data.compareTo(element);
        if (comparatorValue < 0) {
            node.left = remove(node.left, element);
        } else if (comparatorValue > 0) {
            node.right = remove(node.right, element);
        } else {
            if (node.left == null && node.right == null) {
                node.data =  null;
                node.left = node.right = null;
                return null;
            }
            if (node.left == null) {
                BinaryTreeNode<T> rightNode = node.right;
                node.data = null;
                node.left = node.right = null;
                node = null;
                return rightNode;
            } else if (node.right == null) {
                BinaryTreeNode<T> leftNode = node.left;
                node.data = null;
                node.left = node.right = null;
                node = null;
                return leftNode;
            } else {
                BinaryTreeNode<T> temp = digLeft(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
            return node;
        }
        return node;
    }

    private BinaryTreeNode<T> digLeft(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> trav = node;
        while (trav.left != null) {
            trav = trav.left;
        }
        return trav;
    }

    @Override
    public boolean contains(T element) {
     return contains(rootNode, element);
    }

    private boolean contains(BinaryTreeNode<T> node, T element) {
        if (node == null) {
            return false;
        }
        int comparedValue = element.compareTo(node.data);
        if (comparedValue < 0) {
            return contains(node.left, element);
        } else if (comparedValue > 0) {
            return contains(node.right, element);
        } else {
            return true;
        }
    }

    @Override
    public int height() {
      return height(rootNode);
    }


    private int height(BinaryTreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public Iterator<T> iterator(TreeTraversalOrder treeTraversalOrder, boolean isRecursive) {
        return new BinarySearchTreeIterator<>(treeTraversalOrder, rootNode, isRecursive);
    }



    private static class BinarySearchTreeIterator<T extends Comparable<T>> implements Iterator<T> {
        private final ArrayList<T> list;
        private final BinaryTreeNode<T> rootNode;
        private int index = 0;
        public BinarySearchTreeIterator(TreeTraversalOrder treeTraversalOrder, BinaryTreeNode<T> rootNode, boolean isRecursive) {
            list = new ArrayList<>();
            this.rootNode = rootNode;
            if (isRecursive){
                traverseRecursively(list, treeTraversalOrder);
            } else {
                traverseIteratively(list, treeTraversalOrder);
            }
        }


        public void traverseIteratively(ArrayList<T> arrayList,TreeTraversalOrder order) {
            switch (order) {
                case IN_ORDER:{
                     InOrderTraversal.iterativeTraversal(arrayList, rootNode);
                     break;
                }
                case PRE_ORDER: {
                    PreOrderTraversal.iterativeTraversal(arrayList, rootNode);
                    break;
                }
                case POST_ORDER: {
                    PostOrderTraversal.iterativeTraversal(arrayList, rootNode);
                    break;
                }
                case LEVEL_ORDER: {
                    LevelOrderTraversal.iterativeTraversal(arrayList, rootNode);
                    break;
                }
            }
        }

        public void traverseRecursively(ArrayList<T> arrayList,TreeTraversalOrder order) {
            switch (order) {
                case IN_ORDER:{
                    InOrderTraversal.recursiveTraversal(arrayList, rootNode);
                    break;
                }
                case PRE_ORDER: {
                    PreOrderTraversal.recursiveTraversal(arrayList, rootNode);
                    break;
                }
                case POST_ORDER: {
                    PostOrderTraversal.recursiveTraversal(arrayList, rootNode);
                    break;
                }
                case LEVEL_ORDER: {
                    LevelOrderTraversal.recursiveTraversal(arrayList, rootNode);
                    break;
                }
            }
        }


        @Override
        public boolean hasNext() {
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return index >= 0 && index < list.size();
        }

        @Override
        public T next() {
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return list.get(index++);
        }
    }

    @Override
    public String toString() {
        return TreePrinter.getTreeDisplay(rootNode);
    }

}
