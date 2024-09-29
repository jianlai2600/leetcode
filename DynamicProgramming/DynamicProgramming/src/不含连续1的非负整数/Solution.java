package 不含连续1的非负整数;

class Solution {
    public boolean haveConsecutiveOne(int num) {

        String s = Integer.toBinaryString(num);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '1') {
                return true;
            }
        }
        return false;
    }
    public int findIntegers(int n) {

        int ret = 0;

        for (int i = 0; i <= n; i++) {
            if (haveConsecutiveOne(i)) {
                ret++;
            }
        }

        return n + 1 - ret;
    }
    public static void main(String[] args) {

        int n = 5;

        Solution sol = new Solution();
        int ret = sol.findIntegers(n);

        System.out.println(ret);
    }
}


