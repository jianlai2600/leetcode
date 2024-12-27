package 捕获黑皇后需要的最少移动次数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int car(int xc, int yc, int xe, int ye, int xt, int yt) {

        if (xc == xt) {
            if (xe == xc && ye > Math.min(yc, yt) && ye < Math.max(yc, yt)) {
                return 2;
            } else {
                return 1;
            }
        }
        if (yc == yt) {
            if (ye == yc && xe > Math.min(xc, xt) && xe < Math.max(xc, xt)) {
                return 2;
            } else {
                return 1;
            }
        }
        return 2;
    }
    public int elephant(int xc, int yc, int xe, int ye, int xt, int yt) {

        float f1 = ((float) xe - xt) / ((float) ye - yt);
        float f2 = ((float) xe - xc) / ((float) ye - yc);

        if (Math.abs(f1) == 1) {
            if (f2 == f1) {
                if (xc > Math.min(xe, xt) && xc < Math.max(xe, xt) && yc > Math.min(ye, yt) && yc < Math.max(ye, yt)) {
                    return 2;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
        return 2;
    }
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {

        return Math.min(car(a, b, c, d, e, f), elephant(a, b, c, d, e, f));
    }
    public static void main(String[] args) {

        int a = 5, b = 8, c = 8, d = 8, e = 1, f = 8;

        Solution sol = new Solution();
        int ret = sol.minMovesToCaptureTheQueen(a, b, c, d, e, f);

        System.out.println(ret);
    }
}