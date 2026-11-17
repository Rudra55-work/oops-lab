import java.util.PriorityQueue;
public class Q23PriorityQueuePeek {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(25); queue.add(5); queue.add(15);
        System.out.println("Head: " + queue.peek());
        System.out.println("Queue after peek (unchanged): " + queue);
    }
}
