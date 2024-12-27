package throughput;

import java.util.*;

class Throughput {

    public static void bfs(int curIndex, List<Integer> serverTasks, boolean[]visited, int curSum, int curCnt) {

        if (curCnt == visited.length) {
            ans = Math.max(ans, curSum);
            return;
        }
        // 0, 4, 2, 1, 3
        if (curIndex != serverTasks.get(curIndex)) {
            while (!visited[curIndex] && !visited[serverTasks.get(curIndex)]) {
                curSum += serverTasks.get(curIndex);
                curCnt++;
                visited[curIndex] = true;

                curIndex = serverTasks.get(curIndex);
            }
        } else {
            curSum += curIndex;
            visited[curIndex] = true;
            curCnt++;
        }

        if (visited[serverTasks.get(curIndex)]) {
            visited[curIndex] = true;
            curCnt++;
        }

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {
                bfs(i, serverTasks, visited, curSum, curCnt);
            }
        }
        if (curCnt == visited.length) {
            ans = Math.max(ans, curSum);
        }
    }

    static long ans;

    public static long calculateMaxProcessingThroughput(List<Integer> serverTasks) {
        // Write your code here

        ans = 0;
        int n = serverTasks.size();

        for (int i = 0; i < n; i++) {
            boolean[]visited = new boolean[n];
            bfs(i, serverTasks, visited, 0, 0);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> serverTasks = Arrays.asList(0, 4, 2, 1, 3); // 9
        long result = Throughput.calculateMaxProcessingThroughput(serverTasks);
        System.out.println("Maximum Throughput Score: " + result);
    }
}

