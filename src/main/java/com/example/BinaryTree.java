package com.example;

import com.example.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree<T> {
    BinaryTreeNode<T> root;
    ArrayList<BinaryTreeNode<T>> listOfNodes;
    int size;

    public BinaryTree(){
        root = null;
        listOfNodes = new ArrayList<>();
    }

    public BinaryTree(BinaryTreeNode<T> root){
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot(){
        return root;
    }

    public void setRoot(BinaryTreeNode<T> node){
        root = node;
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public int size(){
        return size;
    }

    public boolean contains(T element){
        listOfNodes = this.inOrder();
        for (BinaryTreeNode<T> n : listOfNodes) {
            if (n.getElement().equals(element)) return true;
        }

        return false;
    }

    // iterative inorder
    public ArrayList<BinaryTreeNode<T>> inOrder() {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.getLeftChild();
            } else {
                root = stack.pop();
                listOfNodes.add(root);
                root = root.getRightChild();
            }
        }

        return listOfNodes;
    }

    public ArrayList<BinaryTreeNode<T>> preOrder() {
        if(root == null) {
            return null;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> n = stack.pop();

            if(n.getRightChild() != null){
                stack.push(n.getRightChild());
            }
            if(n.getLeftChild() != null){
                stack.push(n.getLeftChild());
            }
        }

        return listOfNodes;
    }

    public ArrayList<BinaryTreeNode<T>> postOrder() {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        if (root == null) {
            return listOfNodes;
        }

        stack.push(root);
        BinaryTreeNode<T> prev = null;

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> current = stack.peek();

            if (prev == null || prev.getLeftChild() == current || prev.getRightChild() == current) {
                if (current.getLeftChild() != null) {
                    stack.push(current.getLeftChild());
                } else if (current.getRightChild() != null) {
                    stack.push(current.getRightChild());
                } else {
                    stack.pop();
                    listOfNodes.add(current);
                }
            }

            else if (current.getLeftChild() == prev) {
                if (current.getRightChild() != null) {
                    stack.push(current.getRightChild());
                } else {
                    stack.pop();
                    listOfNodes.add(current);
                }
            } else if (current.getRightChild() == prev) {
                stack.pop();
                listOfNodes.add(current);
            }

            prev = current;
        }

        return listOfNodes;
    }

    public ArrayList<BinaryTreeNode<T>> levelOrder() {
        Queue<BinaryTreeNode<T>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryTreeNode<T> temp = q.poll();
            listOfNodes.add(temp);
            if (temp.getLeftChild() != null) {
                q.add(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                q.add(temp.getRightChild());
            }
        }

        return listOfNodes;
    }

    public int height(BinaryTreeNode<T> node){
        if(root == null){
            return 0;
        }
        else {
            int leftHeight = 0, rightHeight = 0;

            if(node.getLeftChild() != null){
                leftHeight = height(node.getLeftChild());
            }
            if(node.getRightChild() != null){
                rightHeight = height(node.getRightChild());
            }

            int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;

            return (max + 1);
        }
    }

}
