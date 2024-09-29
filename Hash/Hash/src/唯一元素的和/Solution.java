package 唯一元素的和;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int sumOfUnique(int[] nums) {

        int ret = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                ret += key;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[]nums = {1,2,3,2};

        Solution sol = new Solution();
        int ret = sol.sumOfUnique(nums);

        System.out.println(ret);
    }
}



