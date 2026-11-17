import java.util.LinkedList;
public class Q10LinkedListPrint {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Apple"); fruits.add("Mango"); fruits.add("Banana");
        for (String fruit : fruits) System.out.println(fruit);
    }
}
