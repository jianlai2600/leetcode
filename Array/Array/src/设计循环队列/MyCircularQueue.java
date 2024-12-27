package 设计循环队列;

class MyCircularQueue {
    int size, left, right;
    int[]arr;
    int maxSize;
    public MyCircularQueue(int k) {

        size = 0;
        arr = new int[k];
        left = 0;
        right = 0;
        maxSize = k;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }
        size++;
        arr[right] = value;
        right = (right + 1) % maxSize;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }
        size--;
        left = (left + 1) % maxSize;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[left];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (right == 0) {
            return arr[maxSize - 1];
        }
        return arr[right - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}