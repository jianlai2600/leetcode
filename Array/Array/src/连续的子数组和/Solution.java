package 连续的子数组和;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;
        int[]preSum = new int[n + 1];

        int curSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            int curMod = curSum % k;
            preSum[i + 1] = curMod;
            if (map.containsKey(curMod)) {
                if (i + 1 - map.get(curMod) > 1) {
                    return true;
                }
            } else {
                map.put(curMod, i + 1);
            }
        }

        return false;
    }
    public static void main(String[] args) {

        int[] nums = {2, 4, 3};
        int k = 6;

        Solution sol = new Solution();
        boolean ret = sol.checkSubarraySum(nums, k);

        System.out.println(ret);
    }
}