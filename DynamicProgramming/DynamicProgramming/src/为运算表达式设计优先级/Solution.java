package 为运算表达式设计优先级;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer>res = new ArrayList<>();
        if (expression.length() <= 2) {
            res.add(Integer.valueOf(expression));
            return res;
        }

        for (int i = 0; i < expression.length(); i++) {
            Character c = expression.charAt(i);

            if (!Character.isDigit(c)) {
                List<Integer>left = diffWaysToCompute(expression.substring(0, i));
                List<Integer>right = diffWaysToCompute(expression.substring(i + 1));

                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String expression = "2*3-4*5";

        Solution sol = new Solution();
        List<Integer> ret = sol.diffWaysToCompute(expression);

        for (Integer num : ret) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


