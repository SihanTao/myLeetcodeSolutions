package JPMorgan.Q20;

import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      char top = ' ';
      if (!stack.isEmpty()) {
        top = stack.peek();
      }
      stack.push(ch);

      if (stack.size() > 1) {

        switch (ch) {
          case ')':
            if (!tryPop(stack, top, '(')) {
              return false;
            }
            break;
          case ']':
            if (!tryPop(stack, top, '[')) {
              return false;
            }
            break;
          case '}':
            if (!tryPop(stack, top, '{')) {
              return false;
            }
            break;
        }
      }
    }
    return stack.isEmpty();
  }

  private boolean tryPop(Stack<Character> stack, char top, char c) {
    if (top == c) {
      stack.pop();
      stack.pop();
    } else {
      return false;
    }
    return true;
  }
}
