package 全排列;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    List<Integer>ans = new ArrayList<>();
    List<List<Integer>>ret = new ArrayList<>();

    public void backTracking(int[]nums, boolean[]used) {

        if (ans.size() == nums.length) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                ans.add(nums[i]);
                used[i] = true;
                backTracking(nums, used);
                used[i] = false;
                ans.removeLast();
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {

        boolean[]used = new boolean[nums.length];
        backTracking(nums, used);
        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        Solution sol = new Solution();
        List<List<Integer>> ret = sol.permute(nums);

        for (List<Integer> sublist : ret) {
            System.out.println("Sublist: " + sublist);
        }
    }
}