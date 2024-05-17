package Praktikum.modul5.codelab;

/**
 * Innercodelab
 */
class Node {

  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }
}

public class codelab1 {

  public Node root;

  public codelab1() {
    root = null;
  }

  public void addRoot(int data) {
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
    codelab1 tree = new codelab1();

    // Menentukan struktur tree
    tree.addRoot(20);
    tree.root.left = new Node(2);
    tree.root.right = new Node(25);
    tree.root.left.right = new Node(12);
    tree.root.right.right = new Node(16);

    System.out.println("\nPre Order: ");
    tree.preOrder(tree.root);

    System.out.println("\nIn Order: ");
    tree.inOrder(tree.root);

    System.out.println("\nPost Order: ");
    tree.postOrder(tree.root);
  }
}
