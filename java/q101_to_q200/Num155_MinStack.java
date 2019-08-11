package q101_to_q200;

import java.util.PriorityQueue;
import java.util.Stack;

public class Num155_MinStack {

    Stack<Integer> stack;
    PriorityQueue<Integer> queue;
    int index;

    public Num155_MinStack() {
        stack = new Stack();
        queue = new PriorityQueue<>();
        index = -1;
    }

    public void push(int x) {
        stack.push(x);
        queue.add(x);
    }

    public void pop() {
        int x = stack.pop();
        if(queue.peek() == x) {
            queue.poll();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}
