package sub.properties;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRun {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue.size());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.element());

        System.out.println(queue.poll());
        System.out.println(queue.remove());
        System.out.println(queue.peek());

        System.out.println(queue.poll());



    }
}
