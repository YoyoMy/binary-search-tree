package com.example;

import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> {
    BinaryTreeNode<T> root;
    int size;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }
    public void setRoot(BinaryTreeNode<T> root) {
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
    public boolean contains(T element) {
        return containsNodeRecursive(root, element);
    }

    /** Contains */

    private boolean containsNodeRecursive(BinaryTreeNode<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (value == current.getElement()) {
            return true;
        }
        return value.compareTo((T) current.getElement()) == -1
            ? containsNodeRecursive(current.getLeftChild(), value)
            : containsNodeRecursive(current.getRightChild(), value);
    }

    /** In order */

    public ArrayList<T> inOrder() {
        ArrayList<T> result = new ArrayList<>();
        orderInorder(root, result);
        return result;
    }

    void orderInorder(BinaryTreeNode<T> node, ArrayList<T> result) {
        if (node == null)
            return;
        orderInorder(node.getLeftChild(), result);
        result.add((T) node.getElement());
        orderInorder(node.getRightChild(), result);
    }

    public ArrayList<BinaryTreeNode<T>> inOrderNode() {
        ArrayList<BinaryTreeNode<T>> result = new ArrayList();
        orderInorderNode(root, result);
        return result;
    }
    void orderInorderNode(BinaryTreeNode<T> node, ArrayList<BinaryTreeNode<T>> result) {
        if (node == null)
            return;
        orderInorderNode(node.getLeftChild(), result);
        result.add(node);
        orderInorderNode(node.getRightChild(), result);
    }

    /** Preorder */
    public ArrayList<T> preorder() {
        ArrayList<T> result = new ArrayList<>();
        orderPreorder(root, result);
        return result;
    }

    void orderPreorder(BinaryTreeNode<T> node, ArrayList<T> result) {
        if (node == null)
            return;
        result.add((T) node.getElement());
        orderPreorder(node.getLeftChild(), result);
        orderPreorder(node.getRightChild(), result);
    }
    /** Post Order*/

    public ArrayList<T> postorder() {
        ArrayList<T> result = new ArrayList<>();
        orderPostorder(root, result);
        return result;
    }

    void orderPostorder(BinaryTreeNode<T> node, ArrayList<T> result) {
        if (node == null)
            return;

        orderPostorder(node.getLeftChild(), result);
        orderPostorder(node.getRightChild(), result);
        result.add(node.getElement());
    }

    /** Level Order */

    public ArrayList<T> levelOrder() {
        ArrayList<T> result = new ArrayList<>();
        orderLevelorder(result);
        return result;
    }

    private void orderLevelorder(ArrayList<T> result) {
        int h = heightLevelOrder(root);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(root, i, result);
    }

    private void printGivenLevel(BinaryTreeNode<T> root, int level, ArrayList<T> result) {
        if (root == null)
            return;
        if (level == 1)
            result.add((T) root.getElement());
        else if (level > 1) {
            printGivenLevel(root.getLeftChild(), level - 1, result);
            printGivenLevel(root.getRightChild(), level - 1, result);
        }
    }

    /** Height */

    public int height() {
        return height(root);
    }

    private int height(BinaryTreeNode<T> root) {
        if (root == null)
            return -1;
        else {
            int lHeight = height(root.getLeftChild());
            int rHeight = height(root.getRightChild());

            if (lHeight > rHeight)
                return (lHeight + 1);
            else return (rHeight + 1);
        }
    }

    private int heightLevelOrder(BinaryTreeNode<T> root) {
        if (root == null)
            return 0;
        else {
            int lHeight = heightLevelOrder(root.getLeftChild());
            int rHeight = heightLevelOrder(root.getRightChild());

            if (lHeight > rHeight)
                return (lHeight + 1);
            else return (rHeight + 1);
        }
    }
}
