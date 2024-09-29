package 分发饼干;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gPointer = g.length - 1, sPointer = s.length - 1;
        int ret = g.length;

        while (gPointer >= 0 && sPointer >= 0) {
            if (g[gPointer] <= s[sPointer]) {
                ret--;
                gPointer--;
                sPointer--;
            } else {
                gPointer--;
            }
        }
        return g.length - ret;
    }
    
    public static void main(String[] args) {

        int[] g = {1, 2, 3}, s = {1, 1};

        Solution sol = new Solution();
        int ret = sol.findContentChildren(g, s);

        System.out.println(ret);
    }
}

