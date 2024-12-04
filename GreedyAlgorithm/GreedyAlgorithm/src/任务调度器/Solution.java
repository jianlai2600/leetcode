package 任务调度器;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int size = tasks.length;
        int[]arr = new int[26];

        for (Character c : tasks) {
            arr[c - 'A']++;
        }
        Arrays.sort(arr);

        int N = arr[25];

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == N) {
                cnt++;
            }
        }

        return Math.max(size, (N - 1) * (n + 1) + cnt);
    }
    public static void main(String[] args) {

        char[]tasks = {'A','A','A','B','B','B'};
        int n = 2;

        Solution sol = new Solution();
        int ret = sol.leastInterval(tasks, n);

        System.out.println(ret);
    }
}

