package Praktikum.modul4.Tugas;

import java.util.*;

public class kegiatan2 {

  static HashMap<String, String> users = new HashMap<>();
  static HashMap<String, ArrayList<Object>> usersDetails = new HashMap<>();
  static HashMap<String, Integer> candidates = new HashMap<>();
  // static ArrayList<Object> dataUser = new ArrayList<>();

  static kegiatan2 obj = new kegiatan2();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Selamat datang di Sistem Voting Online");

    candidates.put("A", 0);
    candidates.put("C", 0);
    candidates.put("B", 0);

    // users.put("sd@gmail.com", "123");
    // dataUser.add("krs");
    // dataUser.add(12);
    // usersDetails.put("as@gmail.com", dataUser);

    // for (Object x : usersDetails.keySet()) {
    //   System.out.println(usersDetails.get(x));
    // }

    obj.menu();
  }

  public void menu() {
    System.out.println("\nPilih menu:");
    System.out.println("1. Login");
    System.out.println("2. Daftar");
    System.out.println("3. Hasil Vote");
    System.out.print("Pilihan anda : ");

    int pilih = sc.nextInt();

    if (pilih == 1) {
      obj.login();
    } else if (pilih == 2) {
      obj.register();
    } else if (pilih == 3) {
      obj.hasil();
    }
  }

  public void register() {
    String email, nama, password;
    int nik;
    boolean cekEmail = false, cekNik = false;

    //nama
    System.out.print("Input Nama: ");
    nama = sc.next();

    //email
    do {
      System.out.print("Input email: ");
      email = sc.next();

      if (!email.matches(".*@gmail\\.com$")) {
        cekEmail = true;
        System.out.println("Format email salah, harus menggunakan @gmail.com");
      } else if (users.containsKey(email)) {
        cekEmail = true;
        System.out.println("Email sudah tersedia");
      } else {
        cekEmail = false;
      }
    } while (cekEmail);

    //password
    System.out.print("Input password: ");
    password = sc.next();

    //NIK
    do {
      System.out.print("Input NIK: ");
      nik = sc.nextInt();

      for (ArrayList<Object> x : usersDetails.values()) {
        if ((int) x.get(1) == nik) {
          cekNik = true;
          System.out.println("NIK sudah tersedia");
        } else {
          cekNik = false;
        }
      }
    } while (cekNik);

    users.put(email, password);

    ArrayList<Object> dataUser = new ArrayList<>();
    dataUser.add(nama);
    dataUser.add(nik);
    usersDetails.put(email, dataUser);

    for (Object mail : usersDetails.keySet()) {
      System.out.println(mail);
      System.out.println(usersDetails.get(mail));
    }

    System.out.println("Berhasil mendaftar");
    obj.menu();
  }

  public void login() {
    String email, nama, password;
    int nik;
    System.out.print("Input email: ");
    email = sc.next();

    System.out.print("Input password: ");
    password = sc.next();

    ArrayList<Object> userInfo = usersDetails.get(email);
    System.out.println(userInfo.get(0));
  }

  public void pemilihan() {
    System.out.println("Selamat datang di Sistem Voting Online");

    System.out.println("Pilih kandidat yang ingin Anda dukung: ");
    for (String key : candidates.keySet()) {
      System.out.println("- Kandidat " + key);
    }

    System.out.print(
      "Masukkan nama kandidat (atau ketik 'selesai' untuk keluar): "
    );

    String vote = sc.next();

    candidates.put(vote, candidates.get(vote) + 1);
    System.out.println("Terima kasih, suara Anda telah direkam");
  }

  public void hasil() {
    System.out.println("\nHasil voting: ");
    for (String key : candidates.keySet()) {
      System.out.println(
        "- Kandidat " + key + ": " + candidates.get(key) + " suara"
      );
    }
  }
}
