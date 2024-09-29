package 座位预约管理系统;

import java.util.PriorityQueue;

class SeatManager {
    int size;
    PriorityQueue<Integer>pq;
    public SeatManager(int n) {
        size = n;
        pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
    }

    public int reserve() {

        return pq.poll();
    }

    public void unreserve(int seatNumber) {

        pq.add(seatNumber);
    }
}
