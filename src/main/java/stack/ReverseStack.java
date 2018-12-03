package stack;

import java.util.Stack;

/**
 * @author duanyiheng
 */
public class ReverseStack {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int result = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(result);
    }

}
