package 字母移位;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String shiftingLetters(String s, int[] shifts) {

        char[]arr = s.toCharArray();
        int n = shifts.length;

        for (int i = n - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        for (int i = 0; i < n; i++) {
            char c = arr[i];

            arr[i] = (char)('a' + (c - 'a' + shifts[i]) % 26);
        }
        return new String(arr);
    }
    public static void main(String[] args) {

        String s = "ruu";
        int[]shifts = {26, 9, 17};

        Solution sol = new Solution();
        String ret = sol.shiftingLetters(s, shifts);

        System.out.println(ret);
    }
}