package 压缩字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Solution {
    public char[] getCharArrayDigit(int size) {

        List<Character>list = new ArrayList<>();
        int num = 0;
        while (size > 0) {

            int last = size % 10;
            list.add((char) (last + '0'));
            size /= 10;
            num++;
        }

        char[]ret = new char[num];
        int index = 0;
        for (Character c : list.reversed()) {
            ret[index++] = c;
        }
        return ret;
    }
    public int compress(char[] chars) {

        int index = 0;

        Stack<Character>stack = new Stack<>();

        for (Character c : chars) {
            if (!stack.isEmpty() && stack.peek() != c) {

                chars[index++] = stack.peek();
                int size = stack.size();
                char[]charArray = getCharArrayDigit(size);
                if (size > 1) {
                    for (Character numChar : charArray) {
                        chars[index++] = numChar;
                    }
                }
                while (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            stack.push(c);
        }

        chars[index++] = stack.peek();
        int size = stack.size();
        char[]charArray = getCharArrayDigit(size);
        if (size > 1) {
            for (Character numChar : charArray) {
                chars[index++] = numChar;
            }
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }

        return index;
    }
    public static void main(String[] args) {

        char[]chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        Solution sol = new Solution();
        int ret = sol.compress(chars);

        System.out.println(ret);
    }
}