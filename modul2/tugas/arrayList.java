package Praktikum.modul2.tugas;

import java.math.BigInteger;
import java.util.*;

class Contact {

  String nama;
  BigInteger phonenumber;
  
  public Contact(String nama, BigInteger phonenumber) {
    this.nama = nama;
    this.phonenumber = phonenumber;
  }

}

class ContactManager {

  ArrayList<Contact> daftarKontak = new ArrayList<>();
  Scanner sc = new Scanner(System.in);

  public void addContact() {
    System.out.print("Masukkan nama kontak: ");
    String nama = sc.next();

    System.out.print("Masukkan nomor telepon: ");
   
    BigInteger nomor = sc.nextBigInteger();
    Contact objContact = new Contact(nama, nomor);

    daftarKontak.add(objContact);
    System.out.println("Kontak berhasil ditambahkan");
  }

  public void displayContact() {
    if (daftarKontak.size() == 0) {
      System.out.println("Daftar kontak kosong");
    } else {
      for (int index = 0; index < daftarKontak.size(); index++) {
        String stringValue = daftarKontak.get(index).nama;
        BigInteger intValue = daftarKontak.get(index).phonenumber;

        System.out.println(
          index + 1 + ". " + stringValue + " - " + "+62 " + intValue
        );
      }
    }
  }

  public void searchContact() {
    System.out.print("Masukkan nama kontak yang ingin dicari: ");
    String nama = sc.next();
    boolean ditemukan = false;

    for (int index = 0; index < daftarKontak.size(); index++) {
      String stringValue = daftarKontak.get(index).nama;
      BigInteger intValue = daftarKontak.get(index).phonenumber;

      if (stringValue.equalsIgnoreCase(nama)) {
        System.out.println("Kontak ditemukan");

        System.out.println("Nama: " + stringValue);
        System.out.println("Nomor Telepon: " + "+62 " + intValue);

        ditemukan = true;
      }
    }
    if (ditemukan == false) {
      System.out.println("Kontak tidak ditemukan");
    }
  }
}

public class arrayList {

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
