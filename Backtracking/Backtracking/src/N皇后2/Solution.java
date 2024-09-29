package N皇后2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<List<String>>ret =new ArrayList<>();
    ArrayList<String>ans = new ArrayList<>();
    public boolean isValid(int i, int j) {

        if (ans.size() == 0) {
            return true;
        }
        for (int numOfRow = 0; numOfRow < ans.size(); numOfRow++) {

            int numOfCol = ans.get(numOfRow).indexOf("Q");
            if (numOfCol == j) {
                return false;
            }
            if (Math.abs(i - numOfRow) == Math.abs(j - numOfCol)) {
                return false;
            }
        }

        return true;
    }
    public void backtracking(int n, int start, StringBuffer sb) {
        if (ans.size() == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int j = 0; j < n; j++){
            if (isValid(start, j)) {

                //Make string
                for (int i = 0; i < n; i++) {
                    if (i == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
                sb.setLength(0);

                backtracking(n, start + 1, sb); // 递归

                sb.setLength(0);
                ans.removeLast();
            }
        }
    }
    public int totalNQueens(int n) {
        StringBuffer sb = new StringBuffer();
        backtracking(n, 0, sb);
        return ret.size();
    }

    public static void main(String[] args) {

        int n = 4;
        Solution sol = new Solution();
        int ret = sol.totalNQueens(n);

        System.out.println(ret);
    }
}