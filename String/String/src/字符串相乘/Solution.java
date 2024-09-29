package 字符串相乘;

class Solution {
    public String add(String num1, String num2) {

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
    public String multiplyOne(String num, char c, int zeroNum) {

        StringBuffer sb = new StringBuffer();

        int i = num.length() - 1, add = 0;
        int y = c - '0';

        while (i >= 0 || add != 0) {
            int x = i >= 0 ? num.charAt(i) - '0' : 0;
            int result = x * y + add;

            sb.append((char) result % 10);
            add = result / 10;

            i--;
        }

        sb = sb.reverse();
        for (int j = 0; j < zeroNum; j++) {
            sb.append('0');
        }
        return sb.toString();
    }
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ret = "0";

        int j = num2.length() - 1;
        int zeroNum = 0;
        while (j >= 0) {
            char c = num2.charAt(j);
            ret = add(ret, multiplyOne(num1, c, zeroNum++));
            j--;
        }

        return ret;
    }
    public static void main(String[] args) {

        String num1 = "123", num2 = "0";

        Solution sol = new Solution();
        String ret = sol.multiply(num1, num2);

        System.out.println(ret);
    }
}