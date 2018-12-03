package stack;

import java.util.Stack;

/**
 * @author duanyiheng
 */
public class SortOneStackWithAnother {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SortOneStackWithAnother sortOneStackWithAnother = new SortOneStackWithAnother();
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
        sortOneStackWithAnother.sortByStack(stack);
        System.out.println(stack);
    }

    public void sortByStack(Stack<Integer> data) {
        if (null != data && !data.isEmpty()) {
            Stack<Integer> sort = new Stack<>();
            while (!data.isEmpty()) {
                int num = data.pop();
                while (!sort.isEmpty() && num > sort.peek()) {
                    data.push(sort.pop());
                }
                sort.push(num);
            }
            while (!sort.isEmpty()) {
                data.push(sort.pop());
            }
        }
    }
}
