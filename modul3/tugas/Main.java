package Praktikum.modul3.tugas;

import java.util.Scanner;


class Link {

  public int id, jumlahTiket;
  public String nama;
  public Link next;

  public Link(int id, int jumlahTiket, String nama) {
    this.id = id;
    this.jumlahTiket = jumlahTiket;
    this.nama = nama;
  }

  public void displayLink() {
    System.out.println("id."+
      id + " Nama: " + nama + " Jumlah Tiket: " + jumlahTiket + " "
    );
  }
}


class QueueList {

  public Link front;
  public Link rear;

  public QueueList() {
    this.front = null;
    this.rear = null;
  }

  public boolean isEmpty() {
    return front == null;
  }

  public void insert(int id, String nama, int jumlahTiket) {
    Link newLink = new Link(id, jumlahTiket, nama);
    if (isEmpty()) {
      front = newLink;
    } else {
      rear.next = newLink;
    }
    rear = newLink;
  }

  public void display() {
    Link current = front;
    while (current != null) {
      current.displayLink();
      current = current.next;
    }
    System.out.println("");
  }

  public int delete() {
    int temp = front.id;
    if (front.next == null) {
      rear = null;
    }
    front = front.next;
    return temp;
  }
}


class LinkQueue {

  public QueueList theList;

  public LinkQueue() {
    theList = new QueueList();
  }

  public boolean isEmpty() {
    return theList.isEmpty();
  }

  public void enqueue(int id, String nama, int jumlahTiket) {
    theList.insert(id, nama, jumlahTiket);
  }

  public long dequeue() {
    return theList.delete();
  }

  public void displayQueue() {
    theList.display();
  }
}

public class Main {

  public static void main(String[] args) {
    LinkQueue q = new LinkQueue();

    Scanner sc = new Scanner(System.in);
    String ulangi, hapus;
    int id = 0;
    do {
      id++;
      System.out.print("Input nama Anda: ");
      String nama = sc.next();

      System.out.print("Input jumlah tiket: ");
      int tiket = sc.nextInt();

      System.out.print("Apakah anda ingin menambah tiket (y/n): ");
      ulangi = sc.next();

      q.enqueue(id, nama, tiket);
    } while (ulangi.equalsIgnoreCase("y"));
    ulangi = "n";

    q.displayQueue();
    
    do {
      System.out.print("Apakah anda ingin menghapus (y/n): ");
      hapus = sc.next();
      if (hapus.equalsIgnoreCase("y")) {
        q.dequeue();
        q.displayQueue();
        System.out.print("Apakah anda ingin menghapus lagi? (y/n): ");
        ulangi = sc.next();
      }
    } while (ulangi.equalsIgnoreCase("y"));

    q.displayQueue();
  }
}
