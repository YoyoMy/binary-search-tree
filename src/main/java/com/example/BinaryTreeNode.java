package com.example;

public class BinaryTreeNode<T>{
    T element;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    public BinaryTreeNode(T element)
    {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
    public void addLeftChild(BinaryTreeNode child)
    {
        this.leftChild = child;
    }
    public void addRightChild(BinaryTreeNode child)
    {
        this.rightChild = child;
    }
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }
}