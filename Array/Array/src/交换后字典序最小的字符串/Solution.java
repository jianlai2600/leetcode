package 交换后字典序最小的字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String getSmallestString(String s) {

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length() - 1; i++) {
            int num1 = sb.charAt(i) - '0';
            int num2 = sb.charAt(i + 1) - '0';

            if (num1 % 2 == num2 % 2 && num1 > num2) {
                sb.setCharAt(i, (char) (num2 + '0'));
                sb.setCharAt(i + 1, (char) (num1 + '0'));
                return sb.toString();
            }
        }
        return s;
    }
    public static void main(String[] args) {

        String s = "45320";

        Solution sol = new Solution();
        String res = sol.getSmallestString(s);

        System.out.println(res);
    }
}