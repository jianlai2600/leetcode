package 二进制求和;

class Solution {
    public String addBinary(String a, String b) {

        int add = 0;
        int m = a.length() - 1, n = b.length() - 1;

        StringBuffer sb = new StringBuffer();

        while (m >= 0 || n >= 0 || add == 1) {
            int numA = m >= 0 ? a.charAt(m) - '0' : 0;
            int numB = n >= 0 ? b.charAt(n) - '0' : 0;
            int sum = numA + numB + add;

            int digit;

            if (sum >= 2) {
                add = 1;
            } else {
                add = 0;
            }
            digit = sum % 2;
            sb.append((char) (digit + '0'));

            m--;
            n--;
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {

        String a = "1010", b = "1011";

        Solution sol = new Solution();
        String ret = sol.addBinary(a, b);

        System.out.println(ret);
    }
}