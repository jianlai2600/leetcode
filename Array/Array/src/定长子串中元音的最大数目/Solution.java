package 定长子串中元音的最大数目;

import java.util.*;

class Solution {
    public int maxVowels(String s, int k) {

        int n = s.length();
        int[]preSum = new int[n + 1];

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                preSum[i + 1] = preSum[i] + 1;
            } else {
                preSum[i + 1] = preSum[i];
            }
        }

        int res = 0;

        int left = 0, right = left + k;

        while (right <= n) {
            int num = preSum[right] - preSum[left];
            res = Math.max(res, num);
            left++;
            right++;
        }
        return res;
    }
    public static void main(String[] args) {

        String s = "weallloveyou";
        int k = 7;

        Solution sol = new Solution();
        int ret = sol.maxVowels(s, k);

        System.out.println(ret);
    }
}