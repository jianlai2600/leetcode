package 字符串相加;

class Solution {
    public String addStrings(String num1, String num2) {

        StringBuffer sb = new StringBuffer();

        int i = num1.length() - 1, j = num2.length() - 1, add = 0;

        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int result = x + y + add;

            sb.append((char) result % 10);
            add = result / 10;

            i--;
            j--;
        }

        sb = sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {

        String num1 = "11", num2 = "123";

        Solution sol = new Solution();
        String ret = sol.addStrings(num1, num2);

        System.out.println(ret);
    }
}