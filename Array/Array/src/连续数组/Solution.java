package 连续数组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {

        int ret = 0, n = nums.length, preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                preSum += 1;
            } else {
                preSum -= 1;
            }
            if (map.containsKey(preSum)) {
                int preIndex = map.get(preSum);
                ret = Math.max(ret, i - preIndex);
            } else {
                map.put(preSum, i);
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,1,1,0,1,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,1,0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,1,1,1,1,1,0};

        Solution sol = new Solution();
        int ret = sol.findMaxLength(nums);

        System.out.println(ret);
    }
}