package 验证回文串2;

class Solution {
    public boolean isValid(String s, int left, int right) {

        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {

        int n = s.length();

        int left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isValid(s, left + 1, right) || isValid(s, left, right - 1);
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String s = "aba";

        Solution sol = new Solution();
        boolean ret = sol.validPalindrome(s);

        System.out.println(ret);
    }
}