package 组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    List<List<Integer>>ret = new ArrayList<>();
    List<Integer>ans = new ArrayList<>();
    int sum = 0;
    public void backTracking(int startIndex, int[] candidates, int target) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            ans.add(candidates[i]);
            sum += candidates[i];
            backTracking(i, candidates, target);
            sum -= candidates[i];
            ans.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backTracking(0, candidates, target);
        return ret;
    }
    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        Solution sol = new Solution();
        List<List<Integer>> ret = new ArrayList<>();
        ret = sol.combinationSum(candidates, target);

        for (List<Integer> innerList : ret) {
            // 遍历内层列表
            for (Integer value : innerList) {
                System.out.print(value + " ");
            }
            System.out.println(); // 换行，移动到下一行
        }
    }
}