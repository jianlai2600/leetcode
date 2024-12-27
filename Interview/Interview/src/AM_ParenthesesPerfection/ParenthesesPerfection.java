package AM_ParenthesesPerfection;
import java.util.*;

public class ParenthesesPerfection {

    public static int getMaxEfficiencyScore(String s, String kitParentheses, int[] efficiencyRatings) {
        // Step 1: 统计初始字符串的平衡状态
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') balance++;
            else if (ch == ')') balance--;
        }
        int leftNeeded = Math.max(0, -balance);  // 缺少的左括号
        int rightNeeded = Math.max(0, balance); // 缺少的右括号

        // Step 2: 分类工具箱括号
        List<Integer> leftBrackets = new ArrayList<>();
        List<Integer> rightBrackets = new ArrayList<>();

        for (int i = 0; i < kitParentheses.length(); i++) {
            char bracket = kitParentheses.charAt(i);
            int efficiency = efficiencyRatings[i];
            if (bracket == '(') {
                leftBrackets.add(efficiency);
            } else if (bracket == ')') {
                rightBrackets.add(efficiency);
            }
        }

        // Step 3: 按效率分数从高到低排序
        leftBrackets.sort(Collections.reverseOrder());
        rightBrackets.sort(Collections.reverseOrder());

        // Step 4: 补齐缺失的左右括号
        int maxScore = 0;

        // 补充缺失的左括号
        int leftIndex = 0;
        while (leftNeeded > 0) {
            maxScore += leftBrackets.get(leftIndex);
            leftIndex++;
            leftNeeded--;
        }

        // 补充缺失的右括号
        int rightIndex = 0;
        while (rightNeeded > 0) {
            maxScore += rightBrackets.get(rightIndex);
            rightIndex++;
            rightNeeded--;
        }

        // Step 5: 添加额外的平衡括号对
        int i = leftIndex, j = rightIndex; // 指向左括号和右括号的效率列表
        while (i < leftBrackets.size() && j < rightBrackets.size()) {
            int leftScore = leftBrackets.get(i);
            int rightScore = rightBrackets.get(j);

            // 如果添加一对括号使得总分数增加，就添加
            if (leftScore + rightScore > 0) {
                maxScore += leftScore + rightScore;
                i++;
                j++;
            } else {
                break; // 没有分数提升时停止
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        // 示例输入
        String s = ")";
        String kitParentheses = "((())";
        int[] efficiencyRatings = {1, 4, 2, -3, -3};

        // 调用方法并打印结果
        int result = getMaxEfficiencyScore(s, kitParentheses, efficiencyRatings);
        System.out.println("Maximum Efficiency Score: " + result);
    }
}
