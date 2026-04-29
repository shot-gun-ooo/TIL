package collection.stack;

import java.util.Stack;

public class StackRun {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(30);

        stack.push(40);

        System.out.println(stack.size());
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack.search(20));
        System.out.println(stack.empty());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

       try{ stack.pop();    }
       catch (Exception e){
           System.out.println("스택이 비었음");
       }

       long n = 123345;

    }


}
