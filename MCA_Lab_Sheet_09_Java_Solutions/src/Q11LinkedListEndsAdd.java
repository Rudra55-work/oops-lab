import java.util.LinkedList;
public class Q11LinkedListEndsAdd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Middle");
        list.addFirst("Beginning");
        list.addLast("End");
        System.out.println(list);
    }
}
