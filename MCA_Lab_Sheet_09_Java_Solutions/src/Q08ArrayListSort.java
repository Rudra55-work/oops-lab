import java.util.ArrayList;
import java.util.Collections;
public class Q08ArrayListSort {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(40); values.add(10); values.add(30); values.add(20);
        Collections.sort(values);
        System.out.println("Ascending: " + values);
    }
}
