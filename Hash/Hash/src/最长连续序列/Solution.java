package 最长连续序列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {

        int ret = 0;

        Set<Integer>set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }

        for (Integer num : set) {
            if (!set.contains(num + 1)) {
                int curLen = 1;
                int curNum = num;
                while (set.contains(--curNum)) {
                    curLen++;
                }
                ret = Math.max(ret, curLen);
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        Solution sol = new Solution();
        int ret = sol.longestConsecutive(nums);

        System.out.println(ret);
    }
}



