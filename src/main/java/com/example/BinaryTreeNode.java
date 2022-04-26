package com.example;

public class BinaryTreeNode<T>{
    T element;
    BinaryTreeNode<T> leftChild;
    BinaryTreeNode<T> rightChild;

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
    public void addLeftChild(BinaryTreeNode<T> child)
    {
        this.leftChild = child;
    }
    public void addRightChild(BinaryTreeNode<T> child)
    {
        this.rightChild = child;
    }
    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }
    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }
}