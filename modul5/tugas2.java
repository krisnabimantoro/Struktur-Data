package Praktikum.modul5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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
  static HashMap<Integer, String> inventarisBuku = new HashMap<>();

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

    inventarisBuku.put(123, "Java Programming");
    inventarisBuku.put(21, "Phyton Programming");
    inventarisBuku.put(456, "Data Structures and Algorithms");
    inventarisBuku.put(143, "Statistics");
    inventarisBuku.put(789, "Computer Networks");

    for (Integer key : inventarisBuku.keySet()) {
      obj.NewNode(key);
    }

    System.out.println("\nPre Order: ");
    obj.preOrder(obj.root);

    System.out.println("\nIn Order: ");
    obj.inOrder(obj.root);

    System.out.println("\nPost Order: ");
    obj.postOrder(obj.root);
  }
}
