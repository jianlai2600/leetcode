package 柠檬水找零;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                ten++;
                if (five <= 0) {
                    return false;
                }
                five--;
            } else {
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[] bills = {10, 10};

        Solution sol = new Solution();
        boolean ret = sol.lemonadeChange(bills);

        System.out.println(ret);
    }
}

