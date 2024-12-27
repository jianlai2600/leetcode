package 求出出现两次数字的XOR值;

import java.util.*;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {

        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 2) {
                res ^= num;
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[]nums = {1, 2, 1, 3};
        Solution sol = new Solution();
        int res = sol.duplicateNumbersXOR(nums);

        System.out.println(res);
    }
}



