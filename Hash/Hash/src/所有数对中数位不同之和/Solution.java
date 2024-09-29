package 所有数对中数位不同之和;

import java.util.*;

class Solution {
    public long sumDigitDifferences(int[] nums) {

        long ret = 0;
        int len = String.valueOf(nums[0]).length();

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(i, new int[10]);
        }

        for (Integer num : nums) {
            for (int i = 0; i < len; i++) {
                int tmp = num % 10;
                num /= 10;
                map.get(i)[tmp]++;
            }
        }

        for (int i = 0; i < len; i++) {
            int[]count = map.get(i);
            int sum = Arrays.stream(count).sum();
            for (int j = 0; j < 10; j++) {
                ret += (long) count[j] * (sum - count[j]);
            }
        }

        return ret / 2;
    }
    public static void main(String[] args) {

        int[] nums = {13, 23, 12};

        Solution sol = new Solution();
        long ret = sol.sumDigitDifferences(nums);

        System.out.println(ret);
    }
}



