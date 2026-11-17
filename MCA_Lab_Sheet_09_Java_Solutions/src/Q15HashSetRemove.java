import java.util.HashSet;
public class Q15HashSetRemove {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Red"); set.add("Green"); set.add("Blue");
        set.remove("Green");
        System.out.println(set);
    }
}
