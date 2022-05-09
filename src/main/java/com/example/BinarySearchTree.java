package com.example;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(BinarySearchTreeNode<T> node) {
        super(node);
    }

    public boolean insert(T element) {
        BinarySearchTreeNode<T> node = new BinarySearchTreeNode<>(element);
        if (root == null) {
            root = node;
            return true;
        }

        BinarySearchTreeNode<T> prev = null;
        BinarySearchTreeNode<T> temp = (BinarySearchTreeNode<T>) root;

        while (temp != null) {
            if (temp.getElement().compareTo(element) > 0) {
                prev = temp;
                temp = (BinarySearchTreeNode<T>) temp.getLeftChild();
            } else if (temp.getElement().compareTo(element) < 0) {
                prev = temp;
                temp = (BinarySearchTreeNode<T>) temp.getRightChild();
            }
        }
        if (prev.getElement().compareTo(element) > 0) {
            prev.addLeftChild(node);
        } else prev.addRightChild(node);

        return true;
    }

    public boolean removeElement(T element) {
        removeElement((BinarySearchTreeNode<T>) getRoot(), element);
        return true;
    }

    private BinaryTreeNode<T> removeElement(BinarySearchTreeNode<T> root, T element) {
        if (root == null) return null;

        if (element.compareTo(root.getElement()) > 0)
            root.addRightChild(removeElement((BinarySearchTreeNode<T>) root.getRightChild(), element));
        else if (element.compareTo(root.getElement()) < 0)
            root.addLeftChild(removeElement((BinarySearchTreeNode<T>) root.getLeftChild(), element));
        else {
            if (root.getLeftChild() == null && root.getRightChild() == null) {
                root = null;
            } else if (root.getRightChild() != null) {
                root.setElement(successor(root));
                root.addRightChild(removeElement((BinarySearchTreeNode<T>) root.getRightChild(), root.getElement()));
            } else {
                root.setElement(predecessor(root));
                root.addLeftChild(removeElement((BinarySearchTreeNode<T>) root.getLeftChild(), root.getElement()));
            }
        }

        return root;
    }

    private T successor(BinarySearchTreeNode<T> root) {
        root = (BinarySearchTreeNode<T>) root.getRightChild();
        while (root.getLeftChild() != null) {
            root = (BinarySearchTreeNode<T>) root.getLeftChild();
        }

        return root.getElement();
    }

    private T predecessor(BinarySearchTreeNode<T> root) {
        root = (BinarySearchTreeNode<T>) root.getLeftChild();
        while (root.getRightChild() != null) {
            root = (BinarySearchTreeNode<T>) root.getRightChild();
        }

        return root.getElement();
    }

    public T findMin() {
        return super.inOrder().get(0).getElement();
    }

    public T findMax() {
        ArrayList<BinaryTreeNode<T>> inOrder = super.inOrder();
        return inOrder.get(inOrder.size() - 1).getElement();
    }

    public boolean contains(T e) {
        ArrayList<BinaryTreeNode<T>> inOrder = super.inOrder();
        for (BinaryTreeNode<T> node : inOrder) {
            if (node.getElement().equals(e)) {
                return true;
            }
        }
        return false;
    }

    public void reBalance() {
        int end = inOrder().size() - 1;
        setRoot(reBalance(super.inOrder(), 0, end));
    }

    private BinarySearchTreeNode<T> reBalance(ArrayList<BinaryTreeNode<T>> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;

        BinarySearchTreeNode<T> node = (BinarySearchTreeNode<T>) inOrder.get(mid);

        node.addLeftChild(reBalance(inOrder, start, mid - 1));

        node.addRightChild(reBalance(inOrder, mid + 1, end));
        return node;
    }
}
