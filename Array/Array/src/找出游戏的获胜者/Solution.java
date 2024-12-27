package 找出游戏的获胜者;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findTheWinner(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            int len = list.size();
            int step = k % len;

            index = (index + step) % len;
            if (index == 0) {
                list.removeLast();
            } else {
                list.remove(index - 1);
                index--;
            }
        }
        return list.get(0) + 1;
    }
    public static void main(String[] args) {

        int n = 5, k = 2;

        Solution sol = new Solution();
        int ret = sol.findTheWinner(n, k);

        System.out.println(ret);
    }
}