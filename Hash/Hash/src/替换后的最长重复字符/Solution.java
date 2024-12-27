package 替换后的最长重复字符;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public boolean check(int[]arr, int len, int k) {

        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, arr[i]);
        }
        if (max == 0) {
            return true;
        }
        return len - max <= k;
    }
    public int characterReplacement(String s, int k) {

        int n = s.length();

        int left = 0;
        int right = 0;

        int res = -1;
        int len = 0;
        int[]arr = new int[26];

        while (right < n) {
            while (right < n && check(arr, len, k)) {
                res = Math.max(res, len);
                arr[s.charAt(right++) - 'A']++;
                len = right - left;
            }
            if (check(arr, len, k)) {
                res = Math.max(res, len);
            }
            arr[s.charAt(left++) - 'A']--;
            len--;
        }
        return res;
    }
    public int characterReplacement2(String s, int k) {

        int n = s.length();

        int left = 0;
        int right = 0;

        int res = -1;
        int maxCnt = 0;
        int[]arr = new int[26];

        while (right < n) {
            arr[s.charAt(right) - 'A']++;
            maxCnt = Math.max(maxCnt, arr[s.charAt(right) - 'A']);
            right++;

            if (right - left > maxCnt + k) {
                arr[s.charAt(left++) - 'A']--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        Solution sol = new Solution();
        int ret = sol.characterReplacement2(s, k);

        System.out.println(ret);
    }
}



