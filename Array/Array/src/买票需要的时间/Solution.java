package 买票需要的时间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int needToDo = tickets[k] - 1;
        int res = 0;

        for (int i = 0; i < tickets.length; i++) {
            int op = Math.min(needToDo, tickets[i]);
            tickets[i] -= op;
            res += op;
        }

        for (int i = 0; i < k; i++) {
            if (tickets[i] > 0) {
                res++;
            }
        }
        return ++res;
    }
    public static void main(String[] args) {

        int[] tickets = {2,3,2};
        int k = 2;

        Solution sol = new Solution();
        int ret = sol.timeRequiredToBuy(tickets, k);

        System.out.println(ret);
    }
}