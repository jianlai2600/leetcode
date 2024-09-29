package 快乐数;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int retNum(int n) {
        int res = 0;

        while (n != 0) {
            int num = n % 10;
            res += num * num;
            n /= 10;
        }

        return res;
    }
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            n = retNum(n);

            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int n = 19;
        Solution sol = new Solution();
        boolean ret = sol.isHappy(n);

        System.out.println(ret);
    }
}



