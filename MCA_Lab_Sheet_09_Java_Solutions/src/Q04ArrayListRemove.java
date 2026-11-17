import java.util.ArrayList;
public class Q04ArrayListRemove {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); list.add(20); list.add(30); list.add(20);
        list.remove(1);                 // removes element at index 1
        list.remove(Integer.valueOf(20)); // removes first occurrence of value 20
        System.out.println(list);
    }
}
