import java.util.*;
public class Q29SetToList {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(10, 20, 30, 40));
        List<Integer> list = new ArrayList<>(set);
        System.out.println("Converted List:");
        for (Integer value : list) System.out.println(value);
    }
}
