package 分割平衡字符串;

class Solution {
    public int balancedStringSplit(String s) {

        int n = s.length(), i = 0;
        int ret = 0;
        int numR = 0, numL = 0;

        while (i < n) {

            if (s.charAt(i) == 'R') {
                numR++;
            } else {
                numL++;
            }

            if (numR == numL) {
                ret++;
                numR = 0;
                numL = 0;
            }
            i++;
        }

        return ret;
    }
    public static void main(String[] args) {

        String s = "RLRRLLRLRL";

        Solution sol = new Solution();
        int ret = sol.balancedStringSplit(s);

        System.out.println(ret);
    }
}

