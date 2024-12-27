package AM_MaximumCharge;
import java.util.*;

public class MaximumCharge {

    public static int getMaximumCharge(int[] charge) {
        int n = charge.length;
        if (n == 1) return charge[0];

        // dp[i][j] stores the maximum charge from index i to j
        int[][] dp = new int[n][n];

        // Base case: single element subarrays
        for (int i = 0; i < n; i++) {
            dp[i][i] = charge[i];
        }

        // Iterate over subarray lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // Calculate maximum charge by removing each element in the range [i, j]
                int maxCharge = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = (k > i) ? dp[i][k - 1] : 0;
                    int right = (k < j) ? dp[k + 1][j] : 0;
                    maxCharge = Math.max(maxCharge, left + right);
                }

                dp[i][j] = maxCharge;
            }
        }

        return dp[0][n - 1]; // The maximum charge for the entire array
    }

    public static void main(String[] args) {
        // Example input
        int[] charge = {-2, 4, 3, 2, -1};

        // Calculate the maximum possible charge
        int result = getMaximumCharge(charge);
        System.out.println("Maximum charge: " + result);
    }
}
