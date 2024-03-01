package tugas;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Masukkan nama: ");
    String nama = sc.next();

    System.out.print("Masukkan harga: ");
    int harga = sc.nextInt();

    output tampil = new output();
    tampil.main(args);

    System.out.print("Piih Jenis Barang: ");

    int y = sc.nextInt();

    sc.close();

    Barang<String, Integer> barang = new Barang<>(
      nama,
      harga,
      Jenis.values()[y - 1]
    );

    System.out.println("Informasi Barang: ");
    System.out.println("Nama: " + barang.getKey());
    System.out.println("Harga: " + barang.getValue());
    System.out.println("Jenis: " + barang.getJenis());
  }
}

/**
 * output
 */
class output {

  public void main(String[] args) {
    int x = 0;
    for (Jenis jenisBarang : Jenis.values()) {
      x++;
      System.out.print(x + ". ");
      System.out.println(jenisBarang);
    }
  }
}

class Barang<K, V> {

  private K key;
  private V value;

  Jenis jenis;

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public Barang(K key, V value, Jenis jenis) {
    this.key = key;
    this.value = value;
    this.jenis = jenis;
  }

  public Jenis getJenis() {
    return jenis;
  }
}

enum Jenis {
  SANDANG,
  PANGAN,
  PAPAN,
}
