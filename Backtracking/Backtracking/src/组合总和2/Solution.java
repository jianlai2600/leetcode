package 组合总和2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    List<Integer>ans = new ArrayList<>();
    List<List<Integer>>ret = new ArrayList<>();
    int sum = 0;
    public void backTracking(int startIndex, int[] candidates, int target, boolean[]used) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            ans.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;

            backTracking(i + 1, candidates, target, used);
            sum -= candidates[i];
            ans.removeLast();
            used[i] = false;
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        boolean[]used = new boolean[candidates.length];
        backTracking(0, candidates, target, used);
        return ret;
    }
    public static void main(String[] args) {

        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;

        Solution sol = new Solution();
        List<List<Integer>> ret = sol.combinationSum2(candidates, target);

        for (List<Integer> innerList : ret) {
            // 遍历内层列表
            for (Integer value : innerList) {
                System.out.print(value + " ");
            }
            System.out.println(); // 换行，移动到下一行
        }
    }
}