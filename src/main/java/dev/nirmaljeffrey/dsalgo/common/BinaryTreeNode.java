package dev.nirmaljeffrey.dsalgo.common;

public class BinaryTreeNode<T extends Comparable<T>> implements TreePrinter.PrintableNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }


    @Override
    public TreePrinter.PrintableNode<T> getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode<T> getRight() {
        return right;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String getText() {
        return data.toString();
    }
}