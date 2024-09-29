package 和可被K整除的子数组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int n = nums.length;
        int preSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int ret = 0;

        for (int i = 0; i < n; i++) {
            preSum = (preSum + nums[i]) % k;
            if (preSum < 0) {
                preSum += k;
            }
            int index = preSum % k;
            if (map.containsKey(index)) {
                ret += map.get(index);
                map.put(index, map.get(index) + 1);
            } else {
                map.put(index, 1);
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {-1, 2, 9};
        int k = 2;

        Solution sol = new Solution();
        int ret = sol.subarraysDivByK(nums, k);

        System.out.println(ret);
    }
}