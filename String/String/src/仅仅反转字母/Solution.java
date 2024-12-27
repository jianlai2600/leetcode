package 仅仅反转字母;

class Solution {
    public String reverseOnlyLetters(String s) {

        char[]arr = s.toCharArray();

        int left = 0, right = s.length() - 1;

        while (left < right) {

            if (!Character.isLetter(arr[left])) {
                left++;
            } else if (!Character.isLetter(arr[right])) {
                right--;
            } else {
                char c = arr[left];
                arr[left] = arr[right];
                arr[right] = c;
                left++;
                right--;
            }
        }

        return new String(arr);
    }
    public static void main(String[] args) {

        String s = "a-bC-dEf-ghIj";

        Solution sol = new Solution();
        String res = sol.reverseOnlyLetters(s);

        System.out.println(res);
    }
}