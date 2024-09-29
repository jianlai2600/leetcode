package 存在重复元素2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int k = 3;

        Solution sol = new Solution();
        boolean ret = sol.containsNearbyDuplicate(nums, k);

        System.out.println(ret);
    }
}