package 最大回文数字;

import java.util.Arrays;

class Solution {
    public String largestPalindromic(String num) {

        int[]cnt = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int curNum = num.charAt(i) - '0';
            cnt[curNum]++;
        }

        int solo = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int curCnt = cnt[i];
            if (curCnt == 0) {
                continue;
            }
            if (i == 0 && sb.isEmpty()) {
                continue;
            }
            if (curCnt % 2 == 0) {
                curCnt = curCnt / 2;
                for (int j = 0; j < curCnt; j++) {
                    sb.append(i);
                }
            } else {
                curCnt = curCnt / 2;
                for (int j = 0; j < curCnt; j++) {
                    sb.append(i);
                }
                solo = Math.max(solo, i);
            }
        }
        if (solo == -1 && sb.isEmpty()) {
            return "0";
        }
        String reverse = new StringBuilder(sb.toString()).reverse().toString();
        if (solo != -1) {
            sb.append(solo);
        }
        sb.append(reverse);
        return sb.toString();
    }
    public static void main(String[] args) {

        String s = "444947137";

        Solution sol = new Solution();
        String res = sol.largestPalindromic(s);

        System.out.println(res);
    }
}

