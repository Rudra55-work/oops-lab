import java.util.LinkedList;
import java.util.Queue;
public class Q24QueueLinkedList {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("A"); queue.add("B"); queue.add("C");
        System.out.println("Queue: " + queue);
        System.out.println("Removed: " + queue.remove());
        System.out.println("After removal: " + queue);
    }
}
