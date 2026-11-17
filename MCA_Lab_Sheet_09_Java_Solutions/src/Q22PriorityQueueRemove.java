import java.util.PriorityQueue;
public class Q22PriorityQueueRemove {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(40); queue.add(10); queue.add(30); queue.add(20);
        System.out.print("Removal order: ");
        while (!queue.isEmpty()) System.out.print(queue.poll() + " ");
        System.out.println();
    }
}
