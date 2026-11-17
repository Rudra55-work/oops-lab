import java.util.ArrayList;
import java.util.Iterator;
public class Q07ArrayListIterator {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(5); values.add(15); values.add(25);
        Iterator<Integer> it = values.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}
