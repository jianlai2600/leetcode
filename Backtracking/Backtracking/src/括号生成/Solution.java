package 括号生成;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        if (n == 0)return ans;

        backtracking("", n, n, ans);
        return ans;
    }

    public void backtracking(String s, int left, int right, List<String>ans) {

        if (left == 0 && right == 0) {
            ans.add(s);
            return;
        }

        if (left > right)return;

        if (left > 0)
        {
            backtracking(s + "(", left - 1, right, ans);
        }
        if (right > 0)
        {
            backtracking(s + ")", left, right - 1, ans);
        }
    }
    public static void main(String[] args)
    {
        int n = 3;

        Solution sol = new Solution();
        List<String> ret = new ArrayList<>();
        ret = sol.generateParenthesis(n);

        for (String s : ret) {
            System.out.println("String: " + s);
        }
    }
}