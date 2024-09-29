package 长按键入;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isLongPressedName(String name, String typed) {

        int m = name.length(), n = typed.length();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    return false;
                }
                while (j < n - 1 && typed.charAt(j) == typed.charAt(j - 1)) {
                    j++;
                }
                if (name.charAt(i) != typed.charAt(j)) {
                    return false;
                }
            }
        }
        if (i < m) {
            return false;
        }
        if (j < n) {
            while (j < n) {
                if (typed.charAt(j) != typed.charAt(j - 1)) {
                    return false;
                }
                j++;
            }
        }

        return true;
    }
    public static void main(String[] args) {

        String name = "alex", typed = "aaleex";

        Solution sol = new Solution();
        boolean ret = sol.isLongPressedName(name, typed);

        System.out.println(ret);
    }
}