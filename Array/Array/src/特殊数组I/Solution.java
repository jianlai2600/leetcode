package 特殊数组I;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isArraySpecial(int[] nums) {

        int n = nums.length;
        int pre = nums[0] % 2;
        int now;

        for (int i = 1; i < n; i++) {
            now = nums[i] % 2;
            if (now == pre) {
                return false;
            }
            pre = now;
        }
        return true;
    }
    public static void main(String[] args) {

        int[]nums ={4,3,1,6};

        Solution sol = new Solution();
        boolean ret = sol.isArraySpecial(nums);

        System.out.println(ret);
    }
}