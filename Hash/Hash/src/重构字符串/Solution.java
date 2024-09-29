package 重构字符串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reorganizeString(String s) {

        int n = s.length();
        char[]res = new char[n];

        int[]count = new int[26];
        char maxChar = 'a';
        int maxCount = 0;

        for (Character c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > maxCount) {
                maxCount = count[c - 'a'];
                maxChar = c;
            }
        }

        if (maxCount > n - maxCount + 1) {
            return "";
        }

        int i = 0;
        while (maxCount-- > 0) {
            res[i] = maxChar;
            i = i + 2;
        }
        count[maxChar - 'a'] = 0;

        for (int j = 0; j < 26; j++) {
            int cnt = count[j];
            char c = (char)(j + 'a');

            while (cnt-- > 0) {
                if (i >= n) {
                    i = 1;
                }
                res[i] = c;
                i = i + 2;
            }
        }

        return new String(res);
    }
    public static void main(String[] args) {

        String s = "aab";

        Solution sol = new Solution();
        String ret = sol.reorganizeString(s);

        System.out.println(ret);
    }
}



