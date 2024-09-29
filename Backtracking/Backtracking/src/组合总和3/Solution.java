package 组合总和3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>>ret = new ArrayList<>();
    List<Integer>ans = new ArrayList<>();
    int sum = 0;
    public void backTracking(int startIndex, int k, int n) {

        if (sum == n && ans.size() == k) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            ans.add(i);
            sum += i;
            backTracking(i + 1, k, n);
            ans.removeLast();
            sum -= i;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {

        backTracking(1, k, n);
        return ret;
    }

    public static void main(String[] args) {

        int k = 3, n = 9;
        Solution sol = new Solution();
        List<List<Integer>> ret = sol.combinationSum3(k, n);

        for (List<Integer> row : ret) {
            System.out.print("[");
            for (Integer item : row) {
                System.out.print(item + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}