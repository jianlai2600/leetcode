package 使数组中所有元素都等于零;

import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            set.add(num);
        }

        return set.size();
    }
    public static void main(String[] args) {

        int[]nums = {1,5,0,3,5};

        Solution sol = new Solution();
        int res = sol.minimumOperations(nums);

        System.out.println(res);
    }
}
