package 组合;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer>ans = new ArrayList<>();
    List<List<Integer>>ret = new ArrayList<>();
    public void backTracking(int startIndex, int n, int k) {
        if (ans.size() == k) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = startIndex; i <= n - k + ans.size() + 1; i++) {
            ans.add(i);
            backTracking(i + 1, n, k);
            ans.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        backTracking(1, n, k);
        return ret;
    }

    public static void main(String[] args) {

        int n = 4, k = 2;
        Solution sol = new Solution();

        List<List<Integer>>ret = sol.combine(n, k);

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