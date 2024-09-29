package 子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<Integer>ans = new ArrayList<>();
    List<List<Integer>>ret = new ArrayList<>();

    public void backTracking(int[]nums, int len, int startIndex, boolean[]used) {

        if (ans.size() == len) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            ans.add(nums[i]);
            used[i] = true;
            backTracking(nums, len, i + 1, used);
            ans.removeLast();
            used[i] = false;
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        boolean[]used = new boolean[nums.length];
        for (int len = 0; len <= nums.length; len++) {
            backTracking(nums, len, 0, used);
        }
        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        Solution sol = new Solution();
        List<List<Integer>> ret = sol.subsetsWithDup(nums);

        for (List<Integer> sublist : ret) {
            System.out.println("Sublist: " + sublist);
        }
    }
}