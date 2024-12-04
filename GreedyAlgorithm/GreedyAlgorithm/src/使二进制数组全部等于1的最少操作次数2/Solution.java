package 使二进制数组全部等于1的最少操作次数2;

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {

        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] == 0 && cnt % 2 == 0) || (nums[i] == 1 && cnt % 2 == 1)) {
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {

        int[]nums = {0,1,1,0,1};

        Solution sol = new Solution();
        int ret = sol.minOperations(nums);

        System.out.println(ret);
    }
}

