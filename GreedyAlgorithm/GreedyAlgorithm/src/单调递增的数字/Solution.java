package 单调递增的数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int monotoneIncreasingDigits(int n) {

        StringBuffer sb = new StringBuffer(String.valueOf(n));

        int ind = -1;

        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                sb.setCharAt(i, (char) (sb.charAt(i) - 1));
                sb.setCharAt(i + 1, '9');
                ind = i + 1;
            }
        }

        if (ind != -1) {
            for (int i = ind; i < sb.length(); i++) {
                sb.setCharAt(i, '9');
            }
        }

        return Integer.valueOf(sb.toString());
    }
    public static void main(String[] args) {

        int n = 332;

        Solution sol = new Solution();
        int ret = sol.monotoneIncreasingDigits(n);

        System.out.println(ret);
    }
}

