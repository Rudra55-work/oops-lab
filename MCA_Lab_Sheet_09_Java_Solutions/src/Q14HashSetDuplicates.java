import java.util.HashSet;
public class Q14HashSetDuplicates {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(10); set.add(20); set.add(10); set.add(30); set.add(20);
        System.out.println("HashSet: " + set);
        System.out.println("Duplicates are not stored; size = " + set.size());
    }
}
