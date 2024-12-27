package 我的日程安排表1;

import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    List<int[]> arr;
    public MyCalendar() {

        arr = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {

        for (int i = 0; i < arr.size(); i++) {
            int[]cur = arr.get(i);
            int s = cur[0];
            int t = cur[1];
            if (startTime < t && endTime > s) {
                return false;
            }
        }
        int[]tmp = new int[2];
        tmp[0] = startTime;
        tmp[1] = endTime;
        arr.add(tmp);

        return true;
    }
}
