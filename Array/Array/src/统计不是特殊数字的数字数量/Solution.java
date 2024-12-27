package 统计不是特殊数字的数字数量;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int nonSpecialCount(int l, int r) {

        int cnt = r - l + 1;

        int n = (int)Math.sqrt(r);
        int[]arr = new int[n + 1];


        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {

                if (i * i >= l && i * i <= r) {
                    cnt--;
                }
                for (int j = i * 2; j <= n; j += i) {
                    arr[j] = -1;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

        int l = 5, r = 7;

        Solution sol = new Solution();
        int res = sol.nonSpecialCount(l, r);

        System.out.println(res);
    }
}