package 将整数按权重排序;

import java.util.*;

class Solution {
    public int helper(int num) {

        if (map.containsKey(num)) {
            return map.get(num);
        }
        int cnt = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            cnt++;
        }
        map.put(num, cnt);
        return cnt;
    }
    Map<Integer, Integer>map;
    public int getKth(int lo, int hi, int k) {

        map = new HashMap<>();
        int n = hi - lo + 1;
        int[][]arr = new int[n][2];

        for (int i = lo; i <= hi; i++) {
            arr[i - lo][0] = i;
            arr[i - lo][1] = helper(i);
        }
        Arrays.sort(arr, (a, b)->(a[1]-b[1]));

        return arr[k - 1][0];
    }
    public static void main(String[] args) {

        int lo = 12, hi = 15, k = 2;

        Solution sol = new Solution();
        int ret = sol.getKth(lo, hi, k);

        System.out.println(ret);
    }
}