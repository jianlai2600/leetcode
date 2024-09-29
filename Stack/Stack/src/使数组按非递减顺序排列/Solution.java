package 使数组按非递减顺序排列;

import java.util.ArrayDeque;
import java.util.Stack;

class Solution {
    public int totalSteps(int[] nums) {
        var ans = 0;
        var st = new ArrayDeque<int[]>();
        for (var num : nums) {
            var maxT = 0;
            while (!st.isEmpty() && st.peek()[0] <= num)
                maxT = Math.max(maxT, st.pop()[1]);
            maxT = st.isEmpty() ? 0 : maxT + 1;
            ans = Math.max(ans, maxT);
            st.push(new int[]{num, maxT});
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] nums = {5,3,4,4,7,3,6,11,8,5,11};
        Solution sol = new Solution();

        int ret = sol.totalSteps(nums);

        System.out.println(ret);
    }
}