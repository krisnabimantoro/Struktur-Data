package Praktikum.modul5.codelab;

class Node {

  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }
}

public class codelab2 {

  public Node root;

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
    codelab2 tree = new codelab2();

    // Menentukan struktur tree
    tree.NewNode(123);
    tree.NewNode(21);
    tree.NewNode(143);
    tree.NewNode(456);
    tree.NewNode(789);

    System.out.println("\nPre Order: ");
    tree.preOrder(tree.root);

    System.out.println("\nIn Order: ");
    tree.inOrder(tree.root);

    System.out.println("\nPost Order: ");
    tree.postOrder(tree.root);
  }
}
