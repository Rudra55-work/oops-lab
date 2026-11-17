import java.util.*;
public class Q28ListToSet {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Python", "Java", "C++", "Python");
        Set<String> set = new LinkedHashSet<>(list);
        System.out.println("Original List: " + list);
        System.out.println("Set after duplicate removal: " + set);
    }
}
