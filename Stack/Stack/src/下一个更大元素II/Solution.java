package 下一个更大元素II;

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int m = nums.length;
        int[]ret = new int[m];
        Arrays.fill(ret, -1);

        Stack<Integer>stack = new Stack<>();
        //
        stack.push(0);

        for (int i = 1; i < m * 2; i++) {
            while (!stack.isEmpty() && nums[i % m] > nums[stack.peek() % m]) {
                int ind = stack.pop();
                ret[ind % m] = nums[i % m];
            }
            stack.push(i);
        }
        //
        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,3};
        Solution sol = new Solution();

        int[] ret = sol.nextGreaterElements(nums);

        for (Integer i : ret){
            System.out.print (i + " ");
        }
        System.out.println();
    }
}