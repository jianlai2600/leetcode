package 移掉K位数字;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {

        if (num.length() == k) {
            return "0";
        }
        Stack<Integer>stack = new Stack<>();
        int cnt = 0;
        char[]arr = num.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            int digit = arr[i] - '0';

            if (cnt == k) {
                stack.push(digit);
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(digit);
                continue;
            }
            if (digit >= stack.peek()) {
                stack.push(digit);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > digit && cnt < k) {
                stack.pop();
                cnt++;
            }
            stack.push(digit);
        }

        while (cnt < k) {
            stack.pop();
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        int index = 0;
        while (index < sb.length()) {
            if (sb.charAt(index) == '0') {
                index++;
            } else {
                break;
            }
        }
        sb.delete(0, index);

        if (sb.isEmpty()) {
            return "0";
        }

        return sb.toString();
    }
    public static void main(String[] args) {

        String num = "10200";
        int k = 1;

        Solution sol = new Solution();
        String res = sol.removeKdigits(num, k);

        System.out.println(res);
    }
}