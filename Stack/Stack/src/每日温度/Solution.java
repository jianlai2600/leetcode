package 每日温度;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    //Method 1
    public int[] dailyTemperatures1(int[] temperatures) {

        int n = temperatures.length;
        int[] ret = new int[n];

        LinkedList<Integer>stack = new LinkedList<>();
        stack.push(0);

        for (int i = 0; i < n; i++)
        {
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }
            else{
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){

                    ret[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ret;
    }
    //Method 2
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer>stack = new Stack<>();
        int n = temperatures.length;
        int[]ret = new int[n];

        stack.push(0);
        for (int i = 1; i < n; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int ind = stack.pop();
                    ret[ind] = i - ind;
                }
                stack.push(i);
            }
        }

        return ret;
    }
    //Method 3
    public int[] dailyTemperatures3(int[] temperatures) {

        int n = temperatures.length;
        int[]ret = new int[n];

        // 单调栈
        // 求更大，则栈内单调递增

        LinkedList<Integer>stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int index = stack.pop();
                    ret[index] = i - index;
                }
                stack.push(i);
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};
        Solution sol = new Solution();

        int[] ret = sol.dailyTemperatures(temperatures);

        for (Integer i : ret){
            System.out.print (i + " ");
        }
        System.out.println();
    }
}