package 两数之和;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer>map = new HashMap<>();
        int[]res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 9;
        Solution sol = new Solution();
        int[] ret = sol.twoSum(nums, target);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}



