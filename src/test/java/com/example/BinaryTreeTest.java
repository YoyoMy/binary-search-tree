package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class BinaryTreeTest {
  private ArrayList<BinaryTreeNode<Integer>> list = new ArrayList<>();
  private BinaryTree<Integer> tree = new BinaryTree<>();
  private BinarySearchTree<Integer> bst;
  private BinarySearchTree<Integer> bst2;
  private BinaryTreePrint printTree = new BinaryTreePrint();

  @BeforeEach
  void beforeEach() {
    System.out.println("--> setUp()");
    tree.setRoot(new BinaryTreeNode<>(10));
    tree.getRoot().addLeftChild(new BinaryTreeNode<>(7));
    tree.getRoot().getLeftChild().addLeftChild(new BinaryTreeNode<>(1));
    tree.getRoot().getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode<>(2));
    tree.getRoot().getLeftChild().getLeftChild().getRightChild().addRightChild(new BinaryTreeNode<>(3));
    tree.getRoot().getLeftChild().addRightChild(new BinaryTreeNode<>(9));
    tree.getRoot().getLeftChild().getRightChild().addLeftChild(new BinaryTreeNode<>(8));
    tree.getRoot().addRightChild(new BinaryTreeNode<>(25));
    tree.getRoot().getRightChild().addRightChild(new BinaryTreeNode<>(27));
    tree.getRoot().getRightChild().addLeftChild(new BinaryTreeNode<>(15));
    tree.getRoot().getRightChild().getLeftChild().addLeftChild(new BinaryTreeNode<>(13));
    tree.getRoot().getRightChild().getLeftChild().addRightChild(new BinaryTreeNode<>(21));
    bst = new BinarySearchTree<>();
    bst.insert(10);
    bst.insert(7);
    bst.insert(1);
    bst.insert(9);
    bst.insert(2);
    bst.insert(3);
    bst.insert(25);
    bst.insert(15);
    bst.insert(27);
    bst.insert(13);
    bst.insert(21);
    bst.insert(16);
    bst.insert(22);
    bst.insert(18);
    bst2 = new BinarySearchTree<>();
    bst2.insert(10);
    bst2.insert(7);
    bst2.insert(4);
    bst2.insert(8);
    bst2.insert(2);
    bst2.insert(13);
  }

  @Test
  void inOrderTest() {
    list.add(new BinaryTreeNode<>(1));
    list.add(new BinaryTreeNode<>(2));
    list.add(new BinaryTreeNode<>(3));
    list.add(new BinaryTreeNode<>(7));
    list.add(new BinaryTreeNode<>(8));
    list.add(new BinaryTreeNode<>(9));
    list.add(new BinaryTreeNode<>(10));
    list.add(new BinaryTreeNode<>(13));
    list.add(new BinaryTreeNode<>(15));
    list.add(new BinaryTreeNode<>(21));
    list.add(new BinaryTreeNode<>(25));
    list.add(new BinaryTreeNode<>(27));

    ArrayList<BinaryTreeNode<Integer>> temp = tree.inOrder();

    for (int i = 0; i < temp.size(); i++) {
      assertEquals(list.get(i).getElement(), temp.get(i).getElement());
    }
  }

  @Test
  void preOrderTest() {
    list.add(new BinaryTreeNode<>(10));
    list.add(new BinaryTreeNode<>(7));
    list.add(new BinaryTreeNode<>(1));
    list.add(new BinaryTreeNode<>(2));
    list.add(new BinaryTreeNode<>(3));
    list.add(new BinaryTreeNode<>(9));
    list.add(new BinaryTreeNode<>(8));
    list.add(new BinaryTreeNode<>(25));
    list.add(new BinaryTreeNode<>(15));
    list.add(new BinaryTreeNode<>(13));
    list.add(new BinaryTreeNode<>(21));
    list.add(new BinaryTreeNode<>(27));
    ArrayList<BinaryTreeNode<Integer>> temp = tree.preOrder();

    for (int i = 0; i < temp.size(); i++) {
      assertEquals(list.get(i).getElement(), temp.get(i).getElement());
    }

  }

  @Test
  void postOrderTest() {
    list.add(new BinaryTreeNode<>(3));
    list.add(new BinaryTreeNode<>(2));
    list.add(new BinaryTreeNode<>(1));
    list.add(new BinaryTreeNode<>(8));
    list.add(new BinaryTreeNode<>(9));
    list.add(new BinaryTreeNode<>(7));
    list.add(new BinaryTreeNode<>(13));
    list.add(new BinaryTreeNode<>(21));
    list.add(new BinaryTreeNode<>(15));
    list.add(new BinaryTreeNode<>(27));
    list.add(new BinaryTreeNode<>(25));
    list.add(new BinaryTreeNode<>(10));
    ArrayList<BinaryTreeNode<Integer>> temp = tree.postOrder();

    for (int i = 0; i < temp.size(); i++) {
      assertEquals(list.get(i).getElement(), temp.get(i).getElement());
    }
  }

  @Test
  void levelOrderTest() {
    list.add(new BinaryTreeNode<>(10));
    list.add(new BinaryTreeNode<>(7));
    list.add(new BinaryTreeNode<>(25));
    list.add(new BinaryTreeNode<>(1));
    list.add(new BinaryTreeNode<>(9));
    list.add(new BinaryTreeNode<>(15));
    list.add(new BinaryTreeNode<>(27));
    list.add(new BinaryTreeNode<>(2));
    list.add(new BinaryTreeNode<>(8));
    list.add(new BinaryTreeNode<>(13));
    list.add(new BinaryTreeNode<>(21));
    list.add(new BinaryTreeNode<>(3));
    ArrayList<BinaryTreeNode<Integer>> temp = tree.levelOrder();

    for (int i = 0; i < temp.size(); i++) {
      assertEquals(list.get(i).getElement(), temp.get(i).getElement());
    }
  }

  @Test
  void heightTest() {
    int temp = tree.height(tree.getRoot());
    System.out.println(tree.getRoot());
    assertEquals(5 , temp);
  }

  @Test
  void containsTest() {
    tree.setRoot(new BinaryTreeNode<>(10));
    tree.getRoot().addLeftChild(new BinaryTreeNode<>(15));
    assertTrue(tree.contains(15));
  }

  @Test
  void findMinTest() {
    assertEquals(1, bst.findMin());
  }

  @Test
  void findMaxTest() {
    assertEquals(27, bst.findMax());
  }

  @Test
  void insertTest() {
    printTree.printTree(bst.getRoot());
  }

  @Test
  void removeTest() {
    bst.removeElement(1);
    bst.removeElement(15);
    bst.removeElement(10);
    printTree.printTree(bst.getRoot());
  }

  @Test
  void reBalance() {
    bst2.reBalance();
    printTree.printTree(bst2.getRoot());
  }

  @AfterEach
  void afterEach() {
    list.clear();
    bst = null;
    System.out.println("<-- tearDown()");
  }
}
