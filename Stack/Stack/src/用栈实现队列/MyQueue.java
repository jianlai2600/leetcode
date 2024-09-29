package 用栈实现队列;

import java.util.Stack;

class MyQueue {
    Stack<Integer>stack;
    Stack<Integer>tmp;
    int size;
    public MyQueue() {
        stack = new Stack<>();
        tmp = new Stack<>();
        size = 0;
    }

    public void push(int x) {
        stack.push(x);
        size++;
    }

    public int pop() {
        size--;
        for (int i = 0; i < size; i++) {
            tmp.push(stack.pop());
        }
        int val = stack.pop();

        for (int i = 0; i < size; i++) {
            stack.push(tmp.pop());
        }
        return val;
    }

    public int peek() {
        for (int i = 0; i < size - 1; i++) {
            tmp.push(stack.pop());
        }
        int val = stack.peek();

        for (int i = 0; i < size - 1; i++) {
            stack.push(tmp.pop());
        }
        return val;
    }

    public boolean empty() {
        return size == 0;
    }
}