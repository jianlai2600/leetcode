package 按奇偶性交换后的最大数字;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int largestInteger(int num) {

        PriorityQueue<Integer>even = new PriorityQueue<>((a, b)->b - a);
        PriorityQueue<Integer>odd = new PriorityQueue<>((a, b)->b - a);

        String s = String.valueOf(num);

        int ret = 0;

        for (Character c : s.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                even.add(digit);
            } else {
                odd.add(digit);
            }
        }

        for (Character c : s.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                ret = ret * 10 + even.poll();
            } else {
                ret = ret * 10 + odd.poll();
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        int num = 1234;

        Solution sol = new Solution();

        int ret = sol.largestInteger(num);

        System.out.println(ret);
    }
}
