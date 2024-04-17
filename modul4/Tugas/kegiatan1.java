package Praktikum.modul4.Tugas;

import java.util.HashMap;
import java.util.Scanner;

public class kegiatan1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Integer> candidates = new HashMap<>();

    candidates.put("A", 0);
    candidates.put("C", 0);
    candidates.put("B", 0);

    System.out.println("Selamat datang di Sistem Voting Online");

    while (true) {
      System.out.println("Pilih kandidat yang ingin Anda dukung: ");
      for (String key : candidates.keySet()) {
        System.out.println("- Kandidat " + key);
      }

      System.out.print(
        "Masukkan nama kandidat (atau ketik 'selesai' untuk keluar): "
      );

      String vote = sc.next();
      if (!vote.equals("A") && !vote.equals("C") && !vote.equals("B")) {
        break;
      } else {
        candidates.put(vote, candidates.get(vote) + 1);
        System.out.println("Terima kasih, suara Anda telah direkam");
      }
    }

    System.out.println("\nHasil voting: ");
    for (String key : candidates.keySet()) {
      System.out.println(
        "- Kandidat " + key + ": " + candidates.get(key) + " suara"
      );
    }
  }
}
