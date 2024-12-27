package 优质数对的总数1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {

        Map<Integer, Integer>map1 = new HashMap<>();
        Map<Integer, Integer>map2 = new HashMap<>();

        int maxNum = 0;

        for (Integer num1 : nums1) {
            map1.put(num1, map1.getOrDefault(num1, 0) + 1);
            if (num1 > maxNum) {
                maxNum = num1;
            }
        }
        for (Integer num2 : nums2) {
            map2.put(num2, map2.getOrDefault(num2, 0) + 1);
        }

        int res = 0;

        for (Integer key : map2.keySet()) {

            for (int num = key * k; num <= maxNum; num = num + k * key) {
                if (map1.containsKey(num)) {
                    res += map1.get(num) * map2.get(key);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[]nums1 = {5}, nums2 = {2};
        int k = 7;

        Solution sol = new Solution();
        int res = sol.numberOfPairs(nums1, nums2, k);

        System.out.println(res);
    }
}



