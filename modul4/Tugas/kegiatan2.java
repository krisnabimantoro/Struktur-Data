package Praktikum.modul4.Tugas;

import java.util.*;

public class kegiatan2 {

  HashMap<String, String> users = new HashMap<>();
  HashMap<String, List<Object>> usersDetails = new HashMap<>();
  ArrayList<Object> dataUser = new ArrayList<>();


  static kegiatan2 obj = new kegiatan2();
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("Selamat datang di Sistem Voting Online");
    
  }

  public void menu() {
    System.out.println("Selamat datang di Sistem Voting Online");
    System.out.println("Pilih menu:");
    System.out.println("Pilih menu:");
    


  }

  public void register() {
    String email,nama,password;
    int nik;

    System.out.print("Input nama: ");
    nama = sc.next();
    
    System.out.print("\nInput email: ");
    email = sc.next();
    
    System.out.print("\nInput nik: ");
    nik = sc.nextInt();

    System.out.print("\nInput password: ");
    password = sc.next();


    dataUser.add(nama);
    dataUser.add(nik);
    usersDetails.put(email, dataUser);

    users.put(email, password);


  }

  public void login() {
    for (String key : usersDetails.keySet()) {
      System.out.println(key + usersDetails.get(key));
    }
    System.out.println(dataUser.get(0));
  }

  public void pemilihan() {}
}
