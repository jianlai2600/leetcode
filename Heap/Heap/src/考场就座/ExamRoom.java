package 考场就座;

import java.util.PriorityQueue;
import java.util.TreeSet;

class ExamRoom {

    TreeSet<Integer>set;
    int n;
    public ExamRoom(int n) {

        this.n = n;
        set = new TreeSet<>();
    }

    public int seat() {

        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        int idx = 0;
        int len = set.first();

        int pre = set.first();
        for (Integer x : set) {
            int tmpLen = (x - pre) / 2;
            if (tmpLen > len) {
                len = tmpLen;
                idx = (x + pre) / 2;
            }
            pre = x;
        }

        if (n - 1 - set.last() > len) {
            idx = n - 1;
        }
        set.add(idx);
        return idx;
    }

    public void leave(int p) {

        set.remove(p);
    }

    public static void main(String[] args) {
        // 创建 ExamRoom 实例，座位总数为 10
        ExamRoom room = new ExamRoom(10);

        // 调用 seat 方法四次，并打印每次的返回值
        System.out.println("Seat allocated: " + room.seat()); // 第一次调用
        System.out.println("Seat allocated: " + room.seat()); // 第二次调用
        System.out.println("Seat allocated: " + room.seat()); // 第三次调用
        System.out.println("Seat allocated: " + room.seat()); // 第四次调用

        room.leave(4);

        System.out.println("Seat allocated: " + room.seat()); // 第五次调用

    }
}