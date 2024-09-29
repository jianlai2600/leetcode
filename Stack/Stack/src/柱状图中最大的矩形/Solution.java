package 柱状图中最大的矩形;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer>stack = new Stack<>();
        int[]nums = new int[heights.length + 2];
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = heights[i - 1];
        }

        int ret = 0;
        stack.push(0);

        for (int i = 1; i < nums.length; i++) {

            int top = stack.peek();

            if (nums[i] > nums[top]) {
                stack.push(i);
            } else if (nums[i] == nums[top]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] < nums[top]) {
                    int mid = stack.pop();
                    int left = stack.peek();
                    int right = i;

                    int square = nums[mid] * (right - left - 1);
                    ret = Math.max(ret, square);

                    top = stack.peek();
                }
                stack.push(i);
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution sol = new Solution();

        int ret = sol.largestRectangleArea(heights);

        System.out.println(ret);
    }
}