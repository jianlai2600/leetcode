package 四数相加2;

import java.util.*;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int res = 0;

        HashMap<Integer, Integer>map = new HashMap<>();
        for (Integer num1 : nums1) {
            for (Integer num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (Integer num3 : nums3) {
            for (Integer num4 : nums4) {
                if (map.containsKey(- num3 - num4)) {
                    res += map.get(- num3 - num4);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        Solution sol = new Solution();
        int ret = sol.fourSumCount(nums1, nums2, nums3, nums4);

        System.out.println(ret);
    }
}



