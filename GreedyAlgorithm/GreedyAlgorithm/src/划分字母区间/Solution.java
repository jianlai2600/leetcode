package 划分字母区间;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer>ret = new LinkedList<>();

        int n = s.length();
        int[]alpha = new int[26];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            alpha[c - 'a'] = i;
        }

        int ind = 0, range = alpha[s.charAt(0) - 'a'];

        for (int i = 0; i <= range && range < n; i++) {
            char c = s.charAt(i);
            range = Math.max(range, alpha[c - 'a']);
            if (i == range && alpha[c - 'a'] == i) {
                ret.add(i - ind + 1);
                ind = i + 1;
                range++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        String s = "ababcdc";

        Solution sol = new Solution();
        List<Integer> ret = sol.partitionLabels(s);

        System.out.println(ret.toString());
    }
}

