package Praktikum.modul1_Generics_java.codelab;



class Box<T> {

  private T value;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}

public class Main {

  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<>();

    integerBox.setValue(42);
    int intValue = integerBox.getValue();
    System.out.println("Integer value: " + intValue);

    Box<String> stringBox = new Box<>();

    stringBox.setValue("Hello, Generics!");
    String strValue = stringBox.getValue();
    System.out.println("String value: " + strValue);
  }
}
