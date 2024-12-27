package clip;

import javax.xml.transform.SourceLocator;

public class clip {
    static final int MOD = 1000000007;
    // 计算所有平滑片段的总数
    public static long countBalancedClips(int clipLength, int diff) {
        int n = 26;  // 共有 26 个小写字母
        long[][] dp = new long[clipLength][n];

        // 初始化单字母片段 (clipLength == 1)
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 填充 dp 表
        for (int len = 1; len < clipLength; len++) {
            for (int i = 0; i < n; i++) {
                dp[len][i] = 0;  // 重置该长度和字母开头的 dp

                // 只扫描范围内的字符
                int start = Math.max(0, i - diff);
                int end = Math.min(n - 1, i + diff);
                for (int j = start; j <= end; j++) {
                    dp[len][i] = (dp[len][i] + dp[len - 1][j]) % MOD;
                }
            }
        }

        // 计算所有符合条件的字符串片段
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + dp[clipLength - 1][i]) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {

        int clipLength = 2, diff = 25;

        clip c = new clip();
        long res = countBalancedClips(clipLength, diff);

        System.out.println(res);
    }
}
