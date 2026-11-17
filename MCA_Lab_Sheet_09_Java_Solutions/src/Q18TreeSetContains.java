import java.util.TreeSet;
public class Q18TreeSetContains {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10); set.add(20); set.add(30);
        int target = 20;
        System.out.println("Contains " + target + "? " + set.contains(target));
    }
}
