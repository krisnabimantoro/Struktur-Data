package Praktikum.modul5;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

class Node {

  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }
}

public class tugas2 {

  public Node root;
  static HashMap<Integer, String> inventarisBuku = new LinkedHashMap<>();
  static Scanner sc = new Scanner(System.in);

  private Node NewNode(Node root, Node newData) {
    if (root == null) {
      root = newData;
      return root;
    }
    if (newData.data < root.data) {
      root.left = NewNode(root.left, newData);
    } else {
      root.right = NewNode(root.right, newData);
    }
    return root;
  }

  public void NewNode(int data) {
    root = NewNode(root, new Node(data));
  }

  public void inOrder(Node node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(node.data + " " + inventarisBuku.get(node.data));
      inOrder(node.right);
    }
  }

  public void preOrder(Node node) {
    if (node != null) {
      System.out.println(node.data + " " + inventarisBuku.get(node.data));
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  public void postOrder(Node node) {
    if (node != null) {
      postOrder(node.left);
      postOrder(node.right);
      System.out.println(node.data + " " + inventarisBuku.get(node.data));
    }
  }

  public static void main(String[] args) {
    tugas2 obj = new tugas2();
    int isbn;
    String namaBuku;

    inventarisBuku.put(123, "Java Programming");
    inventarisBuku.put(789, "Computer Networks");
    inventarisBuku.put(21, "Phyton Programming");
    inventarisBuku.put(456, "Data Structures and Algorithms");
    inventarisBuku.put(143, "Statistics");  
    inventarisBuku.put(800, "Statistics");  
    inventarisBuku.put(12, "mathematic");
    inventarisBuku.put(70, "Calculus");  

    obj.display();

    try {
      System.out.println("\nTambah data: ");
      System.out.print("ISBN: ");

      isbn = sc.nextInt();

      System.out.print("Nama Buku: ");
      namaBuku = sc.next();
      obj.tambahData(isbn, namaBuku);
    } catch (InputMismatchException e) {
      System.out.println("ISBN harus berupa angka atau nomor buku");
      System.exit(1);
    }

    obj.display();

    for (Integer key : inventarisBuku.keySet()) {
      obj.NewNode(key);
    }

    try {
      System.out.println("\nCari Buku berdasarkan ISBN");

      System.out.print("ISBN: ");
      isbn = sc.nextInt();

      obj.searchNode(obj.root, isbn);
    } catch (InputMismatchException e) {
      System.out.println("ISBN harus berupa angka atau nomor buku");
      System.exit(1);
    }
  }

  public void searchNode(Node root, int value) {
    if (root == null) {
      System.out.println("Buku tidak ditemukan");
      return;
    }
    if (root.data == value) {
      System.out.println("Nama Buku: " + inventarisBuku.get(value));
    } else if (value < root.data) {
      searchNode(root.left, value);
    } else {
      searchNode(root.right, value);
    }
  }

  public void tambahData(Integer isbn, String namaBuku) {
    inventarisBuku.put(isbn, namaBuku);
  }

  public void display() {
    tugas2 objDisplay = new tugas2();

    for (Integer key : inventarisBuku.keySet()) {
      objDisplay.NewNode(key);
    }

    System.out.println(
      "\nInventaris Buku (terurut berdasarkan ISBN - PreOrder): "
    );
    objDisplay.preOrder(objDisplay.root);

    System.out.println(
      "\nInventaris Buku (terurut berdasarkan ISBN - InOrder): "
    );
    objDisplay.inOrder(objDisplay.root);

    System.out.println(
      "\nInventaris Buku (terurut berdasarkan ISBN - PostOrder): "
    );
    objDisplay.postOrder(objDisplay.root);
  }
}

class SearchNode {

  Node root; //root of a binary search tree

  SearchNode() {
    root = null;
  }

  public Node searchNode(Node root, int value) {
    if (root == null) return null;
    if (root.data == value) return root; else if (
      value < root.data
    ) return searchNode( // return true if value is found in binary tree
      root.left,
      value
    ); //traverse left subtree
    else return searchNode(root.right, value); //traverse right subtree
  }
}
