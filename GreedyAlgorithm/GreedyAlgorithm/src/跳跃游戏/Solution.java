package 跳跃游戏;

import java.io.StringReader;

class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length, range = nums[0];

        for (int i = 0; i <= range; i++) {
            if (range >= n - 1) {
                return true;
            }
            range = Math.max(range, i + nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};

        Solution sol = new Solution();

        boolean ret = sol.canJump(nums);

        System.out.println(ret);
    }
}

