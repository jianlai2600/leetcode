package 按照频率将数组升序排序;

import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b)->{
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int num : map.keySet()) {
            pq.offer(new int[]{num, map.get(num)});
        }
        int n = nums.length;
        int idx = 0;

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int num = arr[0];
            int freq = arr[1];
            for (int i = 0; i < freq; i++) {
                nums[i + idx] = num;
            }
            idx += freq;
        }
        return nums;
    }
    public static void main(String[] args) {

        int[] nums = {-1,1,-6,4,5,-6,1,4,1};

        Solution sol = new Solution();
        int[] ret = sol.frequencySort(nums);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}



