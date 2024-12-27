package 生成不含相邻零的二进制字符串;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int len;
    List<String>res = new ArrayList<>();
    public void backTracking(StringBuilder sb) {

        if (sb.length() == len) {
            res.add(sb.toString());
            return;
        }
        StringBuilder tmp = new StringBuilder(sb);

        if (sb.charAt(sb.length() - 1) == '0') {
            sb.append('1');
            backTracking(sb);
            return;
        }
        sb.append('0');
        backTracking(sb);
        sb = tmp;
        sb.append('1');
        backTracking(sb);
    }
    public List<String> validStrings(int n) {

        len = n;

        StringBuilder sb = new StringBuilder();
        sb.append('0');
        backTracking(sb);
        sb.setLength(0);
        sb.append('1');
        backTracking(sb);
        return res;
    }
    public static void main(String[] args) {

        int n = 3;

        Solution sol = new Solution();
        List<String>res = sol.validStrings(n);

        for (String s : res) {
            System.out.println(s);
        }
    }
}


