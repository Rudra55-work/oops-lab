import java.util.LinkedList;
public class Q13LinkedListEndsGet {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("First"); list.add("Second"); list.add("Last");
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
    }
}
