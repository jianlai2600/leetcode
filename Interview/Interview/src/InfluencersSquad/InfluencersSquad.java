package InfluencersSquad;

import java.util.Arrays;

public class InfluencersSquad {

    public static int findMaxSquadSize(int[] engagementScores) {
        // 先对 engagementScores 进行升序排序
        Arrays.sort(engagementScores);

        int maxSquadSize = 1; // 最小的团队至少有1人
        int currentSquadSize = 1;

        // 遍历排序后的数组，计算符合条件的小队
        for (int i = 1; i < engagementScores.length; i++) {
            // 如果当前分数和前一个分数的差值小于等于1
            if (engagementScores[i] - engagementScores[i - 1] <= 1) {
                currentSquadSize++;  // 增加当前小队的成员数
            } else {
                // 否则，更新最大小队大小，并重新开始计数
                maxSquadSize = Math.max(maxSquadSize, currentSquadSize);
                currentSquadSize = 1;  // 开始新的小队
            }
        }

        // 最后再更新一次最大小队大小
        maxSquadSize = Math.max(maxSquadSize, currentSquadSize);

        return maxSquadSize;
    }

    public static void main(String[] args) {
        int[] engagementScores = {12, 12, 10, 11, 16};
        System.out.println("最大小队的大小是: " + findMaxSquadSize(engagementScores));
    }
}
