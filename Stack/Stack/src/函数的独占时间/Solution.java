package 函数的独占时间;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[]res = new int[n];

        Stack<int[]>stack = new Stack<>();
        for (String log : logs) {
            String[]logArr = log.split(":");
            int index = Integer.parseInt(logArr[0]);
            int time = Integer.parseInt(logArr[2]);

            if (logArr[1].equals("start")) {
                if (!stack.isEmpty()) {
                    int[]preArr = stack.peek();
                    int preIndex = preArr[0];
                    res[preIndex] += time - preArr[1];
                }
                stack.push(new int[]{index, time});
            } else {
                int[]preArr = stack.pop();
                res[index] += time - preArr[1] + 1;

                if (!stack.isEmpty()) {
                    stack.peek()[1] = time + 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        List<String> logs = Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8");
        int n = 2;

        Solution sol = new Solution();
        int[]res = sol.exclusiveTime(n, logs);

        for (Integer time : res) {
            System.out.println(time);
        }
    }
}
