package 半有序排列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int semiOrderedPermutation(int[] nums) {


        int n = nums.length;
        int oneIndex = -1;
        int lastNIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1 && oneIndex == -1) {
                oneIndex = i;
            }
            if (nums[i] == n) {
                lastNIndex = i;
            }
        }
        int res = oneIndex + n - lastNIndex - 1;

        if (lastNIndex < oneIndex) {
            res--;
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {2,4,1,3};

        Solution sol = new Solution();
        int ret = sol.semiOrderedPermutation(nums);

        System.out.println(ret);
    }
}



