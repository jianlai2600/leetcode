package 完美数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkPerfectNumber(int num) {

        if (num == 1) {
            return false;
        }
        int sum = 1;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                sum += (num / i);
            }
        }

        return sum == num;
    }
    public static void main(String[] args) {

        int num = 28;

        Solution sol = new Solution();
        boolean ret = sol.checkPerfectNumber(num);

        System.out.println(ret);
    }
}



