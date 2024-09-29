package 递增子序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<Integer>ans = new ArrayList<>();
    List<List<Integer>>ret = new ArrayList<>();
    public void backTracking(int[]nums, int startIndex) {

        if (ans.size() > 1) {
            ret.add(new ArrayList<>(ans));
        }

        Set<Integer>set = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                continue;
            }
            if (ans.isEmpty() || nums[i] >= ans.getLast()) {
                ans.add(nums[i]);
                set.add(nums[i]);
                backTracking(nums, i + 1);
                ans.removeLast();
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {

        backTracking(nums, 0);
        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1};
        Solution sol = new Solution();
        List<List<Integer>> ret = sol.findSubsequences(nums);

        for (List<Integer> sublist : ret) {
            System.out.println("Sublist: " + sublist);
        }
    }
}