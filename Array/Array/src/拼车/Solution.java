package 拼车;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    // 变分数组的妙用
    // dif[i] = count[i] - count[i - 1]
    // Then: sum dif, we can get count[i]

    public boolean carPooling(int[][] trips, int capacity) {

        int range = 0;
        for (int[]trip : trips) {
            range = Math.max(range, trip[2]);
        }

        int[]load = new int[range + 1];
        for (int[]trip : trips) {
            load[trip[1]] += trip[0];
            load[trip[2]] -= trip[0];
        }

        int curLoad = 0;
        for (int l : load) {
            curLoad += l;
            if (curLoad > capacity) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[][]trips = {{2,1,5},{3,3,7}};
        int capacity = 4;

        Solution sol = new Solution();
        boolean ret = sol.carPooling(trips, capacity);

        System.out.println(ret);
    }
}