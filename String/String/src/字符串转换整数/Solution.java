package 字符串转换整数;

class Solution {
    public int myAtoi(String s) {

        int n = s.length();
        if (s.isEmpty()) {
            return 0;
        }
        int res = 0;

        int index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index >= n) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        if (index >= n) {
            return 0;
        }

        if (s.charAt(index) < '0' || s.charAt(index) > '9') {
            return 0;
        }
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        while (index < s.length()) {
            char curChar = s.charAt(index);
            if (curChar >= '0' && curChar <= '9') {


                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && curChar - '0' > Integer.MAX_VALUE % 10)) {
                        return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && curChar - '0' > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + (curChar - '0') * sign;
                index++;
            } else {
                break;
            }
        }

        return res;
    }
    public static void main(String[] args) {

        String s = "   -042";

        Solution sol = new Solution();
        int res = sol.myAtoi(s);

        System.out.println(res);
    }
}