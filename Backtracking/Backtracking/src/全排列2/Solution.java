package 全排列2;

import java.util.*;

class Solution {
    List<Integer>ans = new ArrayList<>();
    List<List<Integer>>ret = new ArrayList<>();
    public void backTracking(int[]nums, boolean[]used) {

        if (ans.size() == nums.length) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (used[i] == false) {
                ans.add(nums[i]);
                used[i] = true;
                backTracking(nums, used);
                used[i] = false;
                ans.removeLast();
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        boolean[]used = new boolean[nums.length];
        backTracking(nums, used);
        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        Solution sol = new Solution();
        List<List<Integer>> ret = sol.permuteUnique(nums);

        for (List<Integer> sublist : ret) {
            System.out.println("Sublist: " + sublist);
        }
    }
}