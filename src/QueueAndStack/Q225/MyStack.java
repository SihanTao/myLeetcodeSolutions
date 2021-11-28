package QueueAndStack.Q225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj = new MyStack();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top(); boolean param_4 = obj.empty();
 */
public class MyStack {

  private final Queue<Integer> q;
  private int top;

  public MyStack() {
    q = new LinkedList<>();
  }

  public void push(int x) {
    q.offer(x);
    top = x;
  }

  public int pop() {
    for (int i = 0; i < q.size() - 2; i++) {
      q.offer(q.poll());
    }
    top = q.poll();
    q.offer(top);
    return q.poll();
  }

  public int top() {
    return this.top;
  }

  public boolean empty() {
    return q.isEmpty();
  }
}
