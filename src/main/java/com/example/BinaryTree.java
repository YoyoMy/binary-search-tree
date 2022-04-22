package com.example;

import java.util.ArrayList;

public class BinaryTree<T> {
    BinaryTreeNode root;
    int size;

    public BinaryTree(){
        this.root = null;
    }

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
    public boolean contains(int element) {
        return containsNodeRecursive(root, element);
    }

    /** Contains */

    private boolean containsNodeRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == (int)current.getElement()) {
            return true;
        }
        return value < (int)current.getElement()
            ? containsNodeRecursive(current.getLeftChild(), value)
            : containsNodeRecursive(current.getRightChild(), value);
    }

    /** In order */

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> result = new ArrayList();
        orderInorder(root, result);
        return result;
    }

    void orderInorder(BinaryTreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;
        orderInorder(node.getLeftChild(), result);
        result.add((int)node.getElement());
        orderInorder(node.getRightChild(), result);
    }

    public ArrayList<BinaryTreeNode> inOrderNode() {
        ArrayList<BinaryTreeNode> result = new ArrayList();
        orderInorderNode(root, result);
        return result;
    }
    void orderInorderNode(BinaryTreeNode node, ArrayList<BinaryTreeNode> result) {
        if (node == null)
            return;
        orderInorderNode(node.getLeftChild(), result);
        result.add(node);
        orderInorderNode(node.getRightChild(), result);
    }

    /** Preorder */

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
