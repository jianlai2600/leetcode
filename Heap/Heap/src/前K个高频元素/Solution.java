package 前K个高频元素;

import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        int[]ret = new int[k];

        Map<Integer, Integer>map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]>pq = new PriorityQueue<>((item1, item2)->item2[1] - item1[1]);

        for (Integer key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }

        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll()[0];
        }

        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {7,7,7,7,7,7,2,2,9};
        int k = 2;

        Solution sol = new Solution();

        int[]ret = sol.topKFrequent(nums, k);

        for (Integer item : ret){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
