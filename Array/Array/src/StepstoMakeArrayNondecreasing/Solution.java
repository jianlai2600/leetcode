package StepstoMakeArrayNondecreasing;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int totalSteps(int[] nums) {

        int res = 0;
        int[]ms = new int[nums.length];
        Stack<Integer>stack = new Stack<>();

        for(int i = 0; i < nums.length; ++i) {
            int cur = 0;
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                cur = Math.max(cur, ms[stack.peek()]);
                stack.pop();
            }
            if(!stack.isEmpty()) {
                res = Math.max(res, cur + 1);
                ms[i] = cur + 1;
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {5,3,4,4,7,3,6,11,8,5,11};

        Solution sol = new Solution();
        int ret = sol.totalSteps(nums);

        System.out.println(ret);
    }
}