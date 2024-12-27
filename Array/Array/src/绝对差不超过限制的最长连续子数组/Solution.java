package 绝对差不超过限制的最长连续子数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int res = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey()> limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {8,2,4,7};
        int limit = 4;

        Solution sol = new Solution();
        int ret = sol.longestSubarray(nums, limit);

        System.out.println(ret);
    }
}