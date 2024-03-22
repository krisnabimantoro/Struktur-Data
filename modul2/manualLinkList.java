package Praktikum.modul2;

import java.util.Scanner;

class Node {

  String name;
  String phoneNumber;
  Node next;

  public Node(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.next = null;
  }
}

class ContactManager {

  Node head = null;
  Scanner sc = new Scanner(System.in);

  public void addContact() {
    System.out.print("Masukkan nama kontak: ");
    String nama = sc.next();

    System.out.print("Masukkan nomor telepon: ");
    String nomor = sc.next();

    Node objContact = new Node(nama, nomor);

    if (head == null) {
      head = objContact;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = objContact;
    }

    System.out.println("Kontak berhasil ditambahkan!");
  }

  public void displayContact() {
    int index = 0;
    if (head == null) {
      System.out.println("Daftar kontak kosong");
    } else if (index == 0) {}
    {
      Node current = head;
      while (current != null) {
        System.out.println(
          index + 1 + ". " + current.name + " - " + current.phoneNumber
        );

        current = current.next;
        index++;
      }
    }
  }

  public void searchContact() {
    if (head == null) {
      System.out.println("Daftar kontak kosong");
    } else {
      System.out.print("Masukkan nama kontak yang ingin dicari: ");
      String nama = sc.next();

      Node current = head;

      boolean ditemukan = false;
      while (current != null) {
        if (current.name.equalsIgnoreCase(nama)) {
          System.out.println("Kontak ditemukan!");
          System.out.println("Nama: " + current.name);
          System.out.println("Nomor Telepon: " + current.phoneNumber);
          ditemukan = true;
          break;
        }
        current = current.next;
      }
      if (ditemukan == false) {
        System.out.println("Kontak tidak ditemukan");
      }
    }
  }
}

public class manualLinkList {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ContactManager objContact = new ContactManager();
    while (true) {
      int pilih;

      System.out.println("\nSelamat datang di Manajemen Kontak!");
      System.out.println(
        "1. Tambah Kontak \n2. Tampilkan Kontak \n3. Cari Kontak \n4. Keluar"
      );

      System.out.print("Pilih menu (1/2/3/4) : ");
      pilih = sc.nextInt();

      if (pilih == 1) {
        objContact.addContact();
      } else if (pilih == 2) {
        objContact.displayContact();
      } else if (pilih == 3) {
        objContact.searchContact();
      } else {
        System.exit(1);
      }
    }
  }
}
