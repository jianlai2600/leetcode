package 反转字符串;

class Solution {
    public void reverseString(char[] s) {

        int left = 0, right = s.length - 1;

        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        Solution sol = new Solution();
        sol.reverseString(s);

        for (Character c : s) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}