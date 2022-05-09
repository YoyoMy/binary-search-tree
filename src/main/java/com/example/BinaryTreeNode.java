package com.example;

public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode() {}

    public BinaryTreeNode(T element) {
        this.element = element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode<T> node) {
        leftChild = node;
    }

    public void addRightChild(BinaryTreeNode<T> node) {
        rightChild = node;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return (leftChild != null) ? leftChild : null;
    }

    public BinaryTreeNode<T> getRightChild() {
        return (rightChild != null) ? rightChild : null;
    }

}
