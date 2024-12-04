package H指数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int res = 0;
        int n = citations.length;

        int ans = 0;

        for (int i = 1; n - i >= 0 ; i++) {
            int index = n - i;
            if (citations[index] >= i) {
                if (i >= ans) {
                    ans = i;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] nums = {1, 1, 3};

        Solution sol = new Solution();
        int ret = sol.hIndex(nums);

        System.out.println(ret);
    }
}