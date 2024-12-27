package 将句子排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String sortSentence(String s) {

        String[] strings = s.split(" ");
        int n = strings.length;

        String[] list = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = strings[i];

            int num = temp.charAt(temp.length() - 1) - '0';
            temp = temp.substring(0, temp.length() - 1);

            list[num - 1] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list[i] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public static void main(String[] args) {

        String s = "is2 sentence4 This1 a3";

        Solution sol = new Solution();
        String ret = sol.sortSentence(s);

        System.out.println(ret);
    }
}