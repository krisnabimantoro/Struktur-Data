package Praktikum.modul2_Array_List_Linked_List.tugas;

import java.util.*;

class Contact {

  String nama;
  int phonenumber;

  public Contact(String nama, int phonenumber) {
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
    int nomor = sc.nextInt();

    Contact objContact = new Contact(nama, nomor);

    daftarKontak.add(objContact);
    System.out.println("Kontak berhasil ditambahkan");
  }

  public void displayContact() {

    for (int index = 0; index < daftarKontak.size(); index++) {
      String stringValue = daftarKontak.get(index).nama;
      int intValue = daftarKontak.get(index).phonenumber;

      System.out.println(index + 1 + ". " + stringValue + " - " + intValue);
    }
  }

  public void searchContact() {}
}

public class tugas1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ContactManager objContact = new ContactManager();
   
    while (true) {
      int pilih;
  
      System.out.println("Selamat datang di Manajemen Kontak!");
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
