package 质数分割;

import java.util.HashSet;
import java.util.Set;

class Solution {

    static final int MOD = 1000000007;

    private static final Set<Integer> primes = new HashSet<>();

    private static void makePrimeSet() {
        int[]primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 113};
        for (int i : primeNumbers) {
            primes.add(i);
        }
    }
    public static int countPrimeStrings(String s) {

        int n = s.length();
        int[]dp = new int[n];

        makePrimeSet();

        int firstNum = Integer.parseInt(s.substring(0, 1));
        if (primes.contains(firstNum)) {
            dp[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0 && i - j < 3; j--) {

                String sub = s.substring(j, i + 1);
                if (sub.charAt(0) == '0') {
                    continue;
                }
                int num = Integer.parseInt(sub);
                if (num >= 2 && num <= 999 && primes.contains(num)) {
                    if (j == 0) {
                        dp[i] = (dp[i] + 1) % MOD;
                    } else {
                        dp[i] = (dp[i] + dp[j - 1]) % MOD;
                    }
                }
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {

        String s = "11375";

        int res = countPrimeStrings(s);
        System.out.println(res);
    }
}


