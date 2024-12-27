package 数组大小减半;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int minSetSize(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer integer : arr) {
            map.put(integer, map.getOrDefault(integer, 0) + 1);
        }
        int n = arr.length;

        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b)->{
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        for (Integer integer : map.keySet()) {
            pq.add(new int[]{integer, map.get(integer)});
        }

        int cnt = 0;
        int curSum = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            curSum += poll[1];
            cnt++;
            if (curSum >= n / 2) {
                break;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

        int[]arr = {3,3,3,3,5,5,5,2,2,7};

        Solution sol = new Solution();
        int ret = sol.minSetSize(arr);

        System.out.println(ret);
    }
}



