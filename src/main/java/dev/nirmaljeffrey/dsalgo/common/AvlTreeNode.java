package dev.nirmaljeffrey.dsalgo.common;

public class AvlTreeNode<T extends Comparable<T>> implements TreePrinter.PrintableNode<T> {
    public int balanceFactor;
    public int height;
    public T data;
    public AvlTreeNode<T> left, right;

    public AvlTreeNode(T data) {
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
