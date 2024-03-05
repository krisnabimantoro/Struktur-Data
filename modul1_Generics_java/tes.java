
import java.util.Arrays;
import java.util.List;

/**
 * tes
 */
public class tes {


    public static void printList(List<?> list) {
        for (Object elm : list) {
            System.out.println(elm +" ");
        }
        System.out.println();
        
    }
  public static void main(String[] args) {
    List<Integer> dataInt = Arrays.asList(1,2,3);

    printList(dataInt);
    
  }
}
