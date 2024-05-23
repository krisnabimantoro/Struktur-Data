package Praktikum.modul5;

import java.util.Scanner;

class Node {

  String data;
  Node left;
  Node right;

  public Node(String data) {
    this.data = data;
  }
}

public class tugas1 {

  public Node root;

  public tugas1() {
    root = null;
  }

  public void addRoot(String data) {
    root = new Node(data);
  }

  public void inOrder(Node node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(node.data + " ");
      inOrder(node.right);
    }
  }

  public void preOrder(Node node) {
    if (node != null) {
      System.out.println(node.data + " ");
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  public void postOrder(Node node) {
    if (node != null) {
      postOrder(node.left);
      postOrder(node.right);
      System.out.println(node.data + " ");
    }
  }

  public static void main(String[] args) {
    tugas1 obj = new tugas1();
    Scanner sc = new Scanner(System.in);

    String input;

    System.out.println("Tambahkan 6 data");
    for (int i = 1; i <= 6; i++) {
      System.out.print("Data ke " + i + ": ");
      input = sc.next();
      if (i == 1) {
        obj.addRoot(input);
      } else if (i == 2) {
        obj.root.left = new Node(input);
      } else if (i == 3) {
        obj.root.right = new Node(input);
      } else if (i == 4) {
        obj.root.left.left = new Node(input);
      } else if (i == 5) {
        obj.root.left.right = new Node(input);
      } else if (i == 2) {
        obj.root.right.left = new Node(input);
      }
    }

    System.out.println("\nPre Order: ");
    obj.preOrder(obj.root);

    System.out.println("\nIn Order: ");
    obj.inOrder(obj.root);

    System.out.println("\nPost Order: ");
    obj.postOrder(obj.root);
  }
}
