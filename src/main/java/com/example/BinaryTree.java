package com.example;

import java.util.ArrayList;

public class BinaryTree<T> {
    BinaryTreeNode root;
    int size;

    public BinaryTreeNode getRoot() {
        return root;
    }
    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
    public boolean isEmpty()
    {
        return size==0;
    }

    public int size()
    {
        return size;
    }
    public boolean contains(T element)
    {
        return false;
    }
    public ArrayList<T> inOrder()
    {
        return null;
    }
    public ArrayList<T> preOrder()
    {
        return null;
    }
    public ArrayList<T> postOrder()
    {
        return null;
    }
    public ArrayList<T> levelOrder()
    {
        return null;
    }
    public int height()
    {
        return 0;
    }
}
