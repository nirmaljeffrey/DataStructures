package dev.nirmaljeffrey.dsalgo.common;

public class AvlTreeNode<T> implements TreePrinter.PrintableNode {
    public int balanceFactor;
    public int height;
    public T value;
    public AvlTreeNode<T> left, right;

    public AvlTreeNode(T value) {
        this.value = value;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return value.toString();
    }
}
