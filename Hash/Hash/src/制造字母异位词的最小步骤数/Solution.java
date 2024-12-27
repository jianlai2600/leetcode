package 制造字母异位词的最小步骤数;

import java.util.Arrays;

class Solution {
    public int minSteps(String s, String t) {

        int[]sArr = new int[26];
        int[]tArr = new int[26];

        for (Character c : s.toCharArray()) {
            sArr[c - 'a']++;
        }
        for (Character c : t.toCharArray()) {
            tArr[c - 'a']++;
        }

        int cnt = 0;

        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(sArr[i] - tArr[i]);
        }

        return cnt / 2;
    }
    public static void main(String[] args) {

        String s = "bab", t = "aba";

        Solution sol = new Solution();
        int res = sol.minSteps(s, t);

        System.out.println(res);
    }
}



