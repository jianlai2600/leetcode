package 双模幂运算;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int powMod(int x, int y, int mod) {

        int rest = 1;

        while (y != 0) {

            if ((y & 1) != 0) {
                rest = rest * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return rest;
    }
    public List<Integer> getGoodIndices(int[][] variables, int target) {

        List<Integer>ret = new ArrayList<>();

        for (int i = 0; i < variables.length; i++) {
            int[]v = variables[i];
            if (powMod(powMod(v[0], v[1], 10), v[2], v[3]) == target) {
                ret.add(i);
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[][] variables ={{2,3,3,10},{3,3,3,1},{6,1,1,4}};
        int target = 2;

        Solution sol = new Solution();
        List<Integer>ret = sol.getGoodIndices(variables, target);

        for (Integer num : ret) {
            System.out.println(num);
        }
    }
}