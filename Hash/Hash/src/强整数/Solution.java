package 强整数;

import java.util.*;

class Solution {
    public int log(int N, int base) {

        int result = (int)(Math.log(N) / Math.log(base));
        return result;
    }
    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Integer> set = new HashSet<>();
        List<Integer>ret = new ArrayList<>();

        if (bound == 0) {
            return ret;
        }

        int xNum = x == 1 ? 0 : log(bound, x);
        int yNum = y == 1 ? 0 : log(bound, y);

        int[]xArr = new int[xNum + 1];
        int[]yArr = new int[yNum + 1];

        for (int i = 0; i <= xNum; i++) {
            xArr[i] = (int) Math.pow((double) x, (double) i);
        }
        for (int i = 0; i <= yNum; i++) {
            yArr[i] = (int) Math.pow((double) y, (double) i);
        }

        for (int i = 0; i <= xNum; i++) {
            for (int j = 0; j <= yNum; j++) {
                if (xArr[i] + yArr[j] <= bound) {
                    set.add(xArr[i] + yArr[j]);
                } else {
                    break;
                }
            }
        }
        for (Integer num : set) {
            ret.add(num);
        }
        return ret;
    }
    public static void main(String[] args) {

        int x = 2, y = 3, bound = 0;

        Solution sol = new Solution();
        List<Integer>ret = sol.powerfulIntegers(x, y, bound);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}



