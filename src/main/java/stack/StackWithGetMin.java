package stack;

import java.util.Stack;

/**
 * @author duanyiheng
 */

public class StackWithGetMin {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public StackWithGetMin(Stack<Integer> dataStack, Stack<Integer> minStack) {
        this.dataStack = dataStack;
        this.minStack = minStack;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public void push(int newNum) {
        this.dataStack.push(newNum);
        if (this.minStack.isEmpty()) {
            this.minStack.push(newNum);
        } else if (newNum < this.minStack.peek()) {
            this.minStack.push(newNum);
        } else {
            int value = this.minStack.peek();
            this.minStack.push(value);
        }
    }

    public int pop(int newNum) {
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        this.minStack.pop();
        return this.dataStack.pop();
    }

    public int getMin(int newNum) {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.minStack.peek();
    }
}
