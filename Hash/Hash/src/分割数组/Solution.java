package 分割数组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {

        if (nums.length % 2 == 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 2) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[] nums = {1,1,2,2,3,4};

        Solution sol = new Solution();
        boolean result = sol.isPossibleToSplit(nums);

        System.out.println(result);
    }
}



