import java.util.*;
public class Q20CompareSets {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(30, 10, 20, 10, 40);
        HashSet<Integer> hash = new HashSet<>(input);
        LinkedHashSet<Integer> linked = new LinkedHashSet<>(input);
        TreeSet<Integer> tree = new TreeSet<>(input);
        System.out.println("HashSet (no guaranteed order): " + hash);
        System.out.println("LinkedHashSet (insertion order): " + linked);
        System.out.println("TreeSet (sorted order): " + tree);
    }
}
