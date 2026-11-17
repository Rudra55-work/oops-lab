import java.util.HashSet;
import java.util.Iterator;
public class Q16HashSetIterator {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(100); set.add(200); set.add(300);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}
