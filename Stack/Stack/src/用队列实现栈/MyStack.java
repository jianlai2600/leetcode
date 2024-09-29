package 用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class MyStack {
    int size;
    Queue<Integer>queue;
    Queue<Integer>tmp;
    public MyStack() {
        queue = new LinkedList<>();
        tmp = new LinkedList<>();
        size = 0;
    }

    public void push(int x) {
        queue.add(x);
        size++;
    }

    public int pop() {
        size--;

        for (int i = 0; i < size; i++) {
            tmp.add(queue.poll());
        }
        int val = queue.poll();

        for (int i = 0; i < size; i++) {
            queue.add(tmp.poll());
        }
        return val;
    }

    public int top() {

        for (int i = 0; i < size - 1; i++) {
            tmp.add(queue.poll());
        }
        int val = queue.poll();

        for (int i = 0; i < size - 1; i++) {
            queue.add(tmp.poll());
        }
        queue.add(val);
        return val;
    }

    public boolean empty() {
        return size == 0;
    }
}
