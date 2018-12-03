package stack;

import java.util.Stack;

/**
 * @author duanyiheng
 */
public class TwoStacksQueue {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.push(1);
        twoStacksQueue.push(2);
        twoStacksQueue.push(3);
        twoStacksQueue.push(4);
        twoStacksQueue.push(5);
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
    }

    public void push(int newNum) {
        this.pushStack.push(newNum);
    }

    public int poll() {
        prepareForPollOrPeek();
        return this.popStack.pop();
    }

    private void prepareForPollOrPeek() {
        if (this.pushStack.isEmpty() && this.popStack.isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        } else if (this.popStack.isEmpty()) {
            while (!this.pushStack.isEmpty()) {
                this.popStack.push(this.pushStack.pop());
            }
        }
    }

    public int peek() {
        prepareForPollOrPeek();
        return this.popStack.peek();
    }
}
