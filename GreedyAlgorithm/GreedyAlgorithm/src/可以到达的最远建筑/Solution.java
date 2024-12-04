package 可以到达的最远建筑;

import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        int n = heights.length;
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int curSum = 0;

        for (int i = 1; i < n; i++) {
            int dif = heights[i] - heights[i - 1];
            if (dif > 0) {
                pq.add(dif);
                if (pq.size() > ladders) {
                    curSum += pq.poll();
                }
                if (curSum > bricks) {
                    return i - 1;
                }
            }
        }
        return n - 1;
    }
    public static void main(String[] args) {

        int[] heights = {4,12,2,7,3,18,20,3,19};
        int bricks = 10, ladders = 2;

        Solution sol = new Solution();
        int ret = sol.furthestBuilding(heights, bricks, ladders);

        System.out.println(ret);
    }
}

