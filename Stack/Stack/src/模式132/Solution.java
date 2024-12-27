package 模式132;

import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {

        int n = nums.length;

        Deque<Integer>deque = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0 ; i--) {

            if (nums[i] < k) {
                return true;
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                int pk = deque.pollLast();
                k = Math.max(k, pk);
            }
            deque.addLast(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[]nums = {-1,3,2,0};

        Solution sol = new Solution();
        boolean res = sol.find132pattern(nums);

        System.out.println(res);
    }
}
