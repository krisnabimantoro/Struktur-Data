## Output
# 1. Codelab 1
Pre Order:
20
2
12
25
16

In Order:
2
12
20
25
16

Post Order:
12
2
16
25
20

# 2. Codelab 2
Pre Order:
20
2
16
25 
37

In Order:
2
16
20 
25 
37

Post Order:
16
2
37
25
20

# Pertanyaan:
Perhatikan code diatas, apakah ada perbedaan antara logika dari code Binary Tree dengan Binary 
Search Tree? Jika ada tunjukkan bagian mana yang berbeda dan jelaskan kepada asisten masing-masing
masing.

# Jawab:
Terdapat perbedaan pada kedua code pada Binary Tree dengan Binary Search Tree
1. Pada Binary tree logika data root dimasukkan menggunakan method addRoot sedangkan pada Binary Search Tree nilai root dimasukkan berdasarkan data yang pertama kali diinput pada argumen tree.NewNode(20);

2. Untuk data baru yang dimasukkan (NewData) juga menggunakan method yang berbeda pada binary tree data baru dimasukkan menggunakan atribut class Node left dan right pada main sedangkan pada binary search tree data baru dimasukkan menggunakan method NewNode

3. Pada binary search tree data baru di tambahkan dan dimasukkan ke subtree berdasarkan data yang baru diinput apakah lebih besar dari nilai root atau tidak, jika data lebih kecil dari nilai root maka akan dimasukkan ke kiri dan jika lebih besar maka di kanan pada method NewNode:
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

3. 
