import java.util.PriorityQueue;
public class Q21PriorityQueueAdd {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(40); queue.add(10); queue.add(30); queue.add(20);
        System.out.println("PriorityQueue internal iteration: " + queue);
        System.out.println("Head (smallest): " + queue.peek());
    }
}
