package Praktikum.modul3.tugas;

import java.util.Scanner;

public class tugasStack {

  private String[] historyUrl;
  private int top;

  public tugasStack(int maxSize) {
    this.historyUrl = new String[maxSize];
    this.top = -1;
  }

  public void visitURL(String url) {
    historyUrl[++top] = url;
  }

  public String back() {
    return historyUrl[top--];
  }

  public String forward() {
    return historyUrl[top++];
  }

  public String getCurrentURL() {
    return historyUrl[top];
  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);

    String[] url = {
      "https://www.example.com/page1",
      "https://www.example.com/page2",
      "https://www.example.com/page3",
      "https://www.example.com/page4",
      "https://www.example.com/page5",
    };

    tugasStack stackUrl = new tugasStack(url.length);

    System.out.println("List link: ");
    for (String isiUrl : url) {
      stackUrl.visitURL(isiUrl);
      System.out.println(stackUrl.getCurrentURL());
    }
    
    System.out.println(" ");

    System.out.println("Anda sekarang mengakses link: ");
    System.out.println(stackUrl.getCurrentURL());

    int pilih;
    while (true) {
      System.out.println("\nUbah link");
      System.out.println("1. Sebelum");
      System.out.println("2. Sesudah");
      System.out.println("3. Keluar");
      System.out.print(
        "Silahkan pilih akses link sebelum atau sesudah (1/2): "
      );

      pilih = sc.nextInt();
      if (pilih == 1) {
        try {
          stackUrl.back();
          if (stackUrl.isEmpty()) {
            System.out.println("Tidak ada link sebelumnya");
          } else {
            System.out.println(
              "\nAnda sekarang mengakses link: \n" + stackUrl.getCurrentURL()
            );
          }
        } catch (Exception e) {
          System.out.println("Tidak ada link sebelumnya");
        }
      } else if (pilih == 2) {
        try {
          stackUrl.forward();
          System.out.println(
            "\nAnda sekarang mengakses link: \n" + stackUrl.getCurrentURL()
          );
        } catch (Exception e) {
          System.out.println("Tidak ada data setelahnya");
        }
      } else {
        break;
      }
    }
  }
}
