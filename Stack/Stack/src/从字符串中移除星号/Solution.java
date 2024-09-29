package 从字符串中移除星号;
import java.util.Stack;

class Solution {
    public String removeStars(String s) {

        StringBuffer sb = new StringBuffer();

        Stack<Character>stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "leet**cod*e";
        Solution sol = new Solution();

        String ret = sol.removeStars(s);

        System.out.println(ret);
    }
}
