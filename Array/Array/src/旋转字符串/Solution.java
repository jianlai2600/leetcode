package 旋转字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();

        sb.append(s);
        sb.append(s);

        String ss = sb.toString();

        return ss.contains(goal);
    }
    public static void main(String[] args) {

        String s = "abcde", goal = "cdeab";

        Solution sol = new Solution();
        boolean ret = sol.rotateString(s, goal);

        System.out.println(ret);
    }
}