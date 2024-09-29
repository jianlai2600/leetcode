package N皇后;

import java.util.*;

class Solution {
    List<String>ans = new LinkedList<>();
    List<List<String>>ret = new LinkedList<>();
    StringBuffer sb = new StringBuffer();
    public int getQPosition(String s) {
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Q') {
                pos = i;
                break;
            }
        }
        return pos;
    }
    public boolean isValid(int i) {

        if (ans.isEmpty()) {
            return true;
        }
        int pos = i;

        for (String str : ans) {
            int strPos = getQPosition(str);
            if (strPos == pos) {
                return false;
            }
            if (Math.abs(strPos - pos) == ans.size() - ans.indexOf(str)) {
                return false;
            }
        }

        return true;
    }

    public String makeString(int n, int pos) {
        sb = new StringBuffer();
        // make string
        for (int i = 0; i < n; i++) {
            if (i == pos) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
    public void backTracking(int n) {

        if (ans.size() == n) {
            ret.add(new LinkedList<>(ans));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (isValid(i)) {
                String s = makeString(n, i);
                ans.add(s);
                backTracking(n);
                ans.removeLast();
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {

        backTracking(n);
        return ret;
    }

    public static void main(String[] args) {

        int n = 4;
        Solution sol = new Solution();
        List<List<String>>ret = sol.solveNQueens(n);

        for (List<String>item : ret) {
            for (String s : item) {
                System.out.println(s + " ");
            }
            System.out.println();
        }
    }
}