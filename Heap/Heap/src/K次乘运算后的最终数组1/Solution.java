package K次乘运算后的最终数组1;

import java.util.*;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b)->{
           if(a[1] == b[1]){
               return a[0] - b[0];
           } else {
               return a[1] - b[1];
           }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{i, nums[i]});
        }

        for (int i = 0; i < k; i++) {
            int[]tmp = pq.poll();
            tmp[1] = tmp[1] * multiplier;
            pq.offer(tmp);
        }
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            nums[tmp[0]] = tmp[1];
        }
        return nums;
    }
    public static void main(String[] args) {

        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;

        Solution sol = new Solution();
        int[]ret = sol.getFinalState(nums, k, multiplier);

        System.out.println(Arrays.toString(ret));
    }
}
