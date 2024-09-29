package 子集;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    List<Integer>ans = new ArrayList<>();
    List<List<Integer>>ret = new ArrayList<>();

    public void backTracking(int[]nums, int startIndex, int len) {

        if (ans.size() == len) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            ans.add(nums[i]);
            backTracking(nums, i + 1, len);
            ans.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {

        for (int i = 0; i <= nums.length; i++) {
            backTracking(nums, 0, i);
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        Solution sol = new Solution();
        List<List<Integer>> ret = sol.subsets(nums);

        for (List<Integer> sublist : ret) {
            System.out.println("Sublist: " + sublist);
        }
    }
}