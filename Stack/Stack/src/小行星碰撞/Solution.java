package 小行星碰撞;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer>stack = new Stack<>();

        for (Integer ast : asteroids) {
            if (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                // collision
                if (ast + stack.peek() == 0) {
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(ast) > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        stack.push(ast);
                    } else {
                        if (stack.peek() + ast == 0) {
                            stack.pop();
                        } else if (stack.peek() < 0) {
                            stack.push(ast);
                        }
                    }
                }
            } else {
                stack.push(ast);
            }
        }
        int[]ret = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
    public static void main(String[] args) {

        int[] asteroids = {-2, 2, 1, -2};
        Solution sol = new Solution();

        int[] ret = sol.asteroidCollision(asteroids);

        for (Integer i : ret){
            System.out.print (i + " ");
        }
        System.out.println();
    }
}