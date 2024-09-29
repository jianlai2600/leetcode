package 最小栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
        min_stack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        min_stack.push(Integer.min(min_stack.peek(), val));
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args)
    {

    }
}