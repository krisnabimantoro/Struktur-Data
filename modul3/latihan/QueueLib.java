package Praktikum.modul3.latihan;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLib {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    @SuppressWarnings("rawtypes")
    // Queue q = new LinkedList<>();

    Queue q = new LinkedList<>();
    
    q.add("Bebek");
    q.add("Angsa");
    q.add("Kuda");
    q.add("Buaya");
    q.add("Tikus");

    System.out.println("Peek: " + q.peek());
    System.out.println("Animasls: " + q);

    q.poll();
    q.poll();
    System.out.println("Animasls: " + q);
  }
}
