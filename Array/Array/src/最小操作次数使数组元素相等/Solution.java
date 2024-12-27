package 最小操作次数使数组元素相等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minMoves(int[] nums) {

        Arrays.sort(nums);

        int minNum = nums[0];

        int cnt = 0;

        for (Integer num : nums) {
            cnt += num - minNum;
        }

        return cnt;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        Solution sol = new Solution();
        int ret = sol.minMoves(nums);

        System.out.println(ret);
    }
}