import java.util.LinkedHashSet;
public class Q19LinkedHashSetOrder {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("Java"); set.add("Python"); set.add("C++"); set.add("Java");
        System.out.println("Insertion order: " + set);
    }
}
