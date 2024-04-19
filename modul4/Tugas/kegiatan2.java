package Praktikum.modul4.Tugas;

import java.util.*;

public class kegiatan2 {

  static HashMap<String, String> users = new HashMap<>();
  static HashMap<String, ArrayList<Object>> usersDetails = new HashMap<>();
  static ArrayList<Object> dataUser = new ArrayList<>();

  static kegiatan2 obj = new kegiatan2();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    dataUser.add("Krisna");
    dataUser.add(13);
    

    usersDetails.put("Krisnabmntr", dataUser);
   
    for (String mail : usersDetails.keySet()) {
      System.out.println(mail + usersDetails.get(mail));
    }
    

    System.out.println("Selamat datang di Sistem Voting Online");
  }

  public void menu() {
    System.out.println("Selamat datang di Sistem Voting Online");
    System.out.println("Pilih menu:");
    System.out.println("Pilih menu:");
  }

  public void register() {
    String email, nama, password;
    int nik;

    System.out.print("Input nama: ");
    nama = sc.next();

    System.out.print("\nInput email: ");
    email = sc.next();

    for (String checkEmail : usersDetails.keySet()) {
      if (email.equals(checkEmail)) {
        System.out.println("Email sudah ada!");
      }
    }


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
