package 有多少小于当前数字的数字;

import java.util.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int n = nums.length;
        int[]ret = Arrays.copyOf(nums, nums.length);
        Map<Integer, Integer>map = new HashMap<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        for (int i = 0; i < n; i++) {
            ret[i] = map.get(ret[i]);
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {8, 1, 2, 2, 3};

        Solution sol = new Solution();
        int[] ret = sol.smallerNumbersThanCurrent(nums);

        for (Integer item : ret){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}