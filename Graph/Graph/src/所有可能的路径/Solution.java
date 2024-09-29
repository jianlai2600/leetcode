package 所有可能的路径;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>>ret = new ArrayList<>();
    List<Integer>ans = new ArrayList<>();
    public void dfs(int[][]graph, int index) {

        if (index == graph.length - 1) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (Integer ind : graph[index]) {
            ans.addLast(ind);
            dfs(graph, ind); // 递归
            ans.removeLast();
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans.add(0);
        dfs(graph, 0);
        return ret;
    }

    public static void main(String[] args){

        int[][] graph = {{1, 2}, {3}, {3}, {}};

        Solution sol = new Solution();
        List<List<Integer>> ret = sol.allPathsSourceTarget(graph);

        for (List<Integer>line : ret) {
            for (Integer item : line) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }
}


