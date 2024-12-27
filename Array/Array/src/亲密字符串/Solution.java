package 亲密字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean buddyStrings(String s, String goal) {

        int[]sArr = new int[26];
        int[]goalArr = new int[26];

        int cnt = 0;
        int m = s.length(), n = goal.length();

        if (m != n) {
            return false;
        }

        boolean haveSame = false;

        for (int i = 0; i < m; i++) {

            sArr[s.charAt(i) - 'a']++;
            goalArr[goal.charAt(i) - 'a']++;

            if (sArr[s.charAt(i) - 'a'] > 1) {
                haveSame = true;
            }
            if (s.charAt(i) != goal.charAt(i)) {
                cnt++;
            }
        }

        if (!Arrays.equals(sArr, goalArr)) {
            return false;
        }

        if (s.equals(goal) && haveSame) {
            return true;
        }
        return cnt == 2;
    }
    public static void main(String[] args) {

        String s = "ab", goal = "ab";

        Solution sol = new Solution();
        boolean res = sol.buddyStrings(s, goal);

        System.out.println(res);
    }
}