package Engagement;

import java.util.Arrays;

public class Engagement {

    public static long getMaxEngagementScore(int[] views, int[] likes) {
        // 对 views 和 likes 进行升序排序
        Arrays.sort(views);
        Arrays.sort(likes);

        int n = views.length;
        int i = n - 1;  // 指向 views 的最大值
        int j = n - 1;  // 指向 likes 的最大值
        long engagementScore = 0;

        // 使用贪心策略，从最大值开始匹配
        while (i >= 0 && j >= 0) {
            if (likes[j] > views[i]) {
                engagementScore += likes[j];  // 满足条件，累加 likes[j] 的值
                i--;  // views 移动到下一个较小的值
                j--;  // likes 总是向前移动，寻找下一个较大的值
            } else {
                i--;
            }
        }

        return engagementScore;
    }

    public static void main(String[] args) {
        int[] views = {10, 20, 30, 40};;
        int[] likes = {5, 25, 35, 15};
        System.out.println("Max Engagement Score: " + getMaxEngagementScore(views, likes));
    }
}
