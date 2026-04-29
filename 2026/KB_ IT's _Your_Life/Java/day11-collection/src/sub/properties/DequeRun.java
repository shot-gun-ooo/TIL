package sub.properties;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeRun {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(100);
        stack.push(33);
        stack.push(13);
        stack.push(54);

        System.out.println(stack.peek());
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
