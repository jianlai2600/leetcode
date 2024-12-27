package 设计一个支持增量操作的栈;

import java.util.LinkedList;

class CustomStack {

    LinkedList<Integer> list;
    int size;
    int maxSize;
    public CustomStack(int maxSize) {
        list = new LinkedList<>();
        size = 0;
        this.maxSize = maxSize;
    }

    public void push(int x) {

        if (size == maxSize) {
            return;
        }
        size++;
        list.addLast(x);
    }

    public int pop() {

        if (size == 0) {
            return -1;
        }
        size--;
        return list.removeLast();
    }

    public void increment(int k, int val) {

        k = Math.min(k, size);
        for (int i = 0; i < k; i++) {
            list.set(i, list.get(i) + val);
        }
    }
}
