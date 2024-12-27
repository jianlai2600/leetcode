package 数的平方等于两数乘积的方法数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {

        Map<Long, Integer> square1 = new HashMap<>();
        Map<Long, Integer> square2 = new HashMap<>();
        Map<Long, Integer> mul1 = new HashMap<>();
        Map<Long, Integer> mul2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            long tmp = (long)num * (long)num;
            square1.put(tmp, square1.getOrDefault(tmp, 0) + 1);

            for (int j = i + 1; j < nums1.length; j++) {
                long tmp2 = (long)nums1[j] * (long)num;
                mul1.put(tmp2, mul1.getOrDefault(tmp2, 0) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            long tmp = (long)num * (long)num;
            square2.put(tmp, square2.getOrDefault(tmp, 0) + 1);

            for (int j = i + 1; j < nums2.length; j++) {
                long tmp2 = (long)nums2[j] * (long)num;
                mul2.put(tmp2, mul2.getOrDefault(tmp2, 0) + 1);
            }
        }

        int result = 0;

        for (Long key : square1.keySet()) {
            if (mul2.containsKey(key)) {
                result += square1.get(key) * mul2.get(key);
            }
        }
        for (Long key : square2.keySet()) {
            if (mul1.containsKey(key)) {
                result += square2.get(key) * mul1.get(key);
            }
        }
        return result;
    }
    public static void main(String[] args) {

        int[] nums1 = {43024,99908};
        int[] nums2 = {1864};

        Solution sol = new Solution();
        int ret = sol.numTriplets(nums1, nums2);

        System.out.println(ret);
    }
}



