package 使两个整数相等的位更改次数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minChanges(int n, int k) {

        int cnt = 0;
        while (n != 0 || k != 0) {
            int numN = n % 2;
            n /= 2;
            int numK = k % 2;
            k /= 2;
            if (numN == 1 && numK == 0) {
                cnt++;
            } else if (numN == 0 && numK == 1) {
                return -1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

        int n = 13, k = 4;

        Solution sol = new Solution();
        int res = sol.minChanges(n, k);

        System.out.println(res);
    }
}