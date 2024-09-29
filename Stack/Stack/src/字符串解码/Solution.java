package 字符串解码;

import java.util.LinkedList;
import java.util.Stack;

class Solution {

    LinkedList<String> string_stack;
    LinkedList<Integer>int_stack;
    public String decodeString(String s) {
        int multi = 0;
        StringBuilder ret = new StringBuilder();

        string_stack = new LinkedList<>();
        int_stack = new LinkedList<>();

        for (Character c : s.toCharArray())
        {
            if (c == '[')
            {
                string_stack.addLast(ret.toString());
                int_stack.addLast(multi);
                multi = 0;
                ret = new StringBuilder();

            } else if (c == ']') {

                StringBuilder tmp = new StringBuilder();
                int num = int_stack.removeLast();
                for (int i = 0; i < num; i++)
                {
                    tmp.append(ret);
                }
                ret = new StringBuilder(string_stack.removeLast() + tmp);

            } else if (Character.isDigit(c)) {
                multi = multi * 10 + Integer.valueOf(c.toString());
            }
            else {
                ret.append(c);
            }
        }

        return ret.toString();
    }

    public static void main(String[] args)
    {
        String s = "3[a]2[bc]";
        Solution sol = new Solution();

        String ret = sol.decodeString(s);

        System.out.println(ret);
    }
}