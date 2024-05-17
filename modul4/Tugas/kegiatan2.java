package Praktikum.modul4.Tugas;

import java.util.*;

public class kegiatan2 {

  static HashMap<String, String> users = new HashMap<>();
  static HashMap<String, ArrayList<Object>> usersDetails = new HashMap<>();
  static HashMap<String, Integer> candidates = new HashMap<>();
  static HashMap<String, Boolean> pemilihan = new HashMap<>();
 

  static kegiatan2 obj = new    kegiatan2();
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Selamat datang di Sistem Voting Online");

    candidates.put("A", 0);
    candidates.put("C", 0);
    candidates.put("B", 0);

    obj.menu();
  }

  public void menu() {
    System.out.println("\nPilih menu:");
    System.out.println("1. Login");
    System.out.println("2. Daftar");
    System.out.println("3. Hasil Vote");
    System.out.println("4. Keluar");
    System.out.print("Pilihan anda : ");

    int pilih = sc.nextInt();

    if (pilih == 1) {
      obj.login();
    } else if (pilih == 2) {
      obj.register();
    } else if (pilih == 3) {
      obj.hasil();
    } else {
      obj.logout();
    }
  }

  public void register() {
    String email, nama, password;
    int nik = 0;
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

 

    System.out.println("Berhasil mendaftar");
    obj.menu();
  }

  public void login() {
    String email, password;

   
    System.out.print("Input email: ");
    email = sc.next();

    System.out.print("Input password: ");
    password = sc.next();

    ArrayList<Object> userInfo = usersDetails.get(email);
   
    if (users.containsKey(email) && users.get(email).equals(password)) {
      if (!email.matches(".*@gmail\\.com$")) {
        System.out.println("Format email tidak sesuai");
        obj.login();
      }

      System.out.println("Login berhasil");
      System.out.println("Nama: " + userInfo.get(0));
      System.out.println("NIK: " + userInfo.get(1));

      if (pemilihan.containsKey(email)) {
        pemilihan.put(email, false);
      } else {
        pemilihan.put(email, true);
      }

      if (pemilihan.get(email) == false) {
        System.out.println("Akun sudah memvoting");
        obj.hasil();
      } else {
        pemilihan.put(email, false);
        obj.pemilihan();
      }
    } else {
      System.out.println("Gagal login");
      obj.login();
    }

  }

  public void pemilihan() {
    System.out.println("\nSelamat datang di Sistem Voting Online");

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
    obj.menu();
  }

  public void hasil() {
    System.out.println("\nHasil voting: ");
    for (String key : candidates.keySet()) {
      System.out.println(
        "- Kandidat " + key + ": " + candidates.get(key) + " suara"
      );
    }
    obj.menu();
  }

  public void logout() {
    System.exit(1);
  }
}
