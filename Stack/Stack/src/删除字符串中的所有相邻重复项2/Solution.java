package 删除字符串中的所有相邻重复项2;

import java.util.Stack;

class Solution {
    public class pair {
        private char c;
        private int num;
        pair(char c, int num) {
            this.c = c;
            this.num = num;
        }
        private void add() {
            this.num++;
        }
        private Character getChar() {
            return this.c;
        }
        private Integer getNum() {
            return this.num;
        }
    }
    public String removeDuplicates(String s, int k) {

        Stack<pair>stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().getChar() == c) {
                pair prePair = stack.pop();
                int preNum = prePair.getNum();

                if (preNum + 1 < k) {
                    prePair.add();
                    stack.push(prePair);
                }
            } else {
                pair p = new pair(c, 1);
                stack.push(p);
            }
        }

        while (!stack.isEmpty()) {
            pair p = stack.pop();
            int num = p.getNum();
            String tmp = p.getChar().toString().repeat(num);

            sb.insert(0, tmp);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "abcd";
        int k = 2;

        Solution sol = new Solution();
        String ret = sol.removeDuplicates(s, k);

        System.out.println(ret);
    }
}