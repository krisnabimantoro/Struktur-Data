package Praktikum.modul4.Tugas;

import java.util.*;

public class kegiatan2 {

  static HashMap<String, String> users = new HashMap<>();
  static HashMap<String, ArrayList<Object>> usersDetails = new HashMap<>();
  static ArrayList<Object> dataUser = new ArrayList<>();

  static kegiatan2 obj = new kegiatan2();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    obj.menu();


    for (String mail : usersDetails.keySet()) {
      System.out.println(mail + usersDetails.get(mail));
    }

  }

  public void menu() {
    System.out.println("Selamat datang di Sistem Voting Online");
    System.out.println("Pilih menu:");
    System.out.println("1. Login");
    System.out.println("2. Daftar");
    System.out.println("3. Hasil Vote");
    System.out.print("Pilihan anda : ");

    int pilih = sc.nextInt();

    if (pilih == 1) {
      obj.login("asd","as");
    } else if (pilih == 2) {
      obj.register();
    } else if (pilih == 3) {
      obj.hasil();
    }
  }

  public void register() {
    String email, nama, password;
    int nik;

    System.out.print("Input nama: ");
    nama = sc.next();

    System.out.print("Input email: ");
    email = sc.next();

    // for (String checkEmail : usersDetails.keySet()) {
    //   if (email.equals(checkEmail)) {
    //     System.out.println("Email sudah ada!");
    //   }
    // }

    System.out.print("Input password: ");
    password = sc.next();
    
    System.out.print("Input nik: ");
    nik = sc.nextInt();


    dataUser.add(nama);
    dataUser.add(nik);
    usersDetails.put(email, dataUser);

    users.put(email, password);
    obj.menu();
  }

  public void login(String email, String password) {

    System.out.print("Input email: ");
    email = sc.next();
    
    System.out.print("Input password: ");
    password = sc.next();



    }

  public void pemilihan() {}

  public void hasil() {}
}
