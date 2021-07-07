package dev.nirmaljeffrey.dsalgo.datastructures.tree;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    private int nodeCount = 0;
    private Node<T> rootNode;


    public boolean isEmpty() {
        return nodeCount == 0;
    }

    public int size() {
        return nodeCount;
    }

    public boolean add(T element) {
     if(contains(element)) {
         return false;
     } else {
        rootNode = addNode(rootNode, element);
         nodeCount++;
         return true;
     }
    }

    private Node<T> addNode(Node<T> root, T element) {
        if (root == null) {
            root = new Node<>(element, null, null);
        } else {
            int comparatorValue = root.data.compareTo(element);
            if (comparatorValue < 0) {
                root.left = addNode(root.left, element);
            } else if (comparatorValue > 0) {
                root.right = addNode(root.right, element);
            }
        }

        return root;
    }

    public boolean remove(T element) {
        if (contains(element)) {
            rootNode = remove(rootNode, element);
            nodeCount--;
            return true;
        }
     return false;
    }
    private Node<T> remove(Node<T> node, T element) {
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
                Node<T> rightNode = node.right;
                node.data = null;
                node.left = node.right = null;
                node = null;
                return rightNode;
            } else if (node.right == null) {
                Node<T> leftNode = node.left;
                node.data = null;
                node.left = node.right = null;
                node = null;
                return leftNode;
            } else {
                Node<T> temp = digLeft(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
            return node;
        }
        return node;
    }

    private Node<T> digLeft(Node<T> node) {
        Node<T> trav = node;
        while (trav != null) {
            trav = trav.left;
        }
        return trav;
    }

    public boolean contains(T element) {
     return contains(rootNode, element);
    }

    private boolean contains(Node<T> node, T element) {
        if (node == null) {
            return false;
        }
        int comparedValue = node.data.compareTo(element);
        if (comparedValue < 0) {
            return contains(node.left, element);
        } else if (comparedValue > 0) {
            return contains(node.right, element);
        } else {
            return true;
        }
    }

    public int height() {
      return height(rootNode);
    }


    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    private static class Node<T> {
        private T data;
        private Node<T> left, right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

}
