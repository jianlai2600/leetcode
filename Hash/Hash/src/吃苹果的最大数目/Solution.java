package 吃苹果的最大数目;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int eatenApples(int[] apples, int[] days) {

        int result = 0;
        // int[0] = day
        // int[1] = number of apple
        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int curDay = 0;
        while (true) {
            if (curDay < days.length) {
                pq.add(new int[]{apples[curDay], curDay + days[curDay]});
            }
            while (!pq.isEmpty() && pq.peek()[1] == curDay) {
                pq.poll();
            }
            if (curDay >= days.length && pq.isEmpty()) {
                break;
            }
            if (!pq.isEmpty()) {
                int[]tmp = pq.poll();
                tmp[0]--;
                result++;
                if (tmp[0] != 0) {
                    pq.add(tmp);
                }
            }

            curDay++;
        }
        return result;
    }
    public static void main(String[] args) {

        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};

        Solution sol = new Solution();
        int ret = sol.eatenApples(apples, days);

        System.out.println(ret);
    }
}



