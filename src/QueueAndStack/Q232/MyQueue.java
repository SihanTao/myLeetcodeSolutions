package QueueAndStack.Q232;

import java.util.Stack;

public class MyQueue {

    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        peek();
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
