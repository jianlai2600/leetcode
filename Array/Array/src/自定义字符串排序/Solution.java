package 自定义字符串排序;

import java.util.Arrays;

class Solution {
    public String customSortString(String order, String s) {

        int[]weight = new int[26];
        for (int i = 0; i < order.length(); i++) {
            weight[order.charAt(i) - 'a'] = i + 1;
        }

        Character[]arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, (a, b)->weight[a - 'a'] - weight[b - 'a']);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
    public static void main(String[] args) {

        String order = "cba", s = "abcd";

        Solution sol = new Solution();
        String ret = sol.customSortString(order, s);

        System.out.println(ret);
    }
}