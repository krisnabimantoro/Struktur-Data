package Praktikum.modul4;

import java.util.ArrayList;
import java.util.List;

public class tesArraylist {

  static List<dataUser> bioadata = new ArrayList<>();

  public static void main(String[] args) {
    bioadata.add(new dataUser("Krisna", 12));

    for (dataUser user : bioadata) {
        System.out.println(user.getNik()+user.getName());
    }
 
  }
}

class dataUser {

  private String name;
  private int nik;

  public dataUser(String name, int nik) {
    this.name = name;
    this.nik = nik;
  }

  public String getName() {
    return name;
  }

  public int getNik() {
    return nik;
  }
}
