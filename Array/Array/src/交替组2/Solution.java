package 交替组1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int numberOfAlternatingGroups(int[] colors) {

        int res = 0;
        int n = colors.length;

        for (int i = 1; i < n - 1; i++) {
            if (colors[i - 1] != colors[i] && colors[i] != colors[i + 1]) {
                res++;
            }
        }
        if (colors[n - 1] != colors[0] && colors[0] != colors[1]) {
            res++;
        }
        if (colors[n - 1] != colors[n - 2] && colors[n - 1] != colors[0]) {
            res++;
        }
        return res;
    }
    public static void main(String[] args) {

        int[] colors = {0,1,0,0,1};

        Solution sol = new Solution();
        int ret = sol.numberOfAlternatingGroups(colors);

        System.out.println(ret);
    }
}