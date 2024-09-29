package 接雨水;

import java.util.Stack;

class Solution {
    public int trap(int[] height) {

        // Please try to remember the process
        // It's the 3rd time you do this problem...
        int ret = 0, m = height.length;
        Stack<Integer>stack = new Stack<>();
        stack.push(0);
        //
        for (int i = 1; i < m; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int w = i - stack.peek() - 1;
                        int h = Math.min(height[i], height[stack.peek()]) - height[mid];

                        ret += w * h;
                    }
                }
                stack.push(i);
            }
        }
        //
        return ret;
    }

    public static void main(String[] args) {

        int[] height = {4, 2, 0, 3, 2, 5};
        Solution sol = new Solution();

        int ret = sol.trap(height);

        System.out.println(ret);
    }
}
