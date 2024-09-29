package 除法求值;


import java.util.*;

class Solution {
    public double dfs(Map<String, Map<String, Double>>map, String src, String tgt, double num, Set<String>visited) {

        if (!map.containsKey(src) || !map.containsKey(tgt)) {
            return -1;
        }
        if (visited.contains(src)) {
            return -1;
        }
        if (src.equals(tgt)) {
            return 1.0;
        }

        visited.add(src);

        Map<String, Double>curNeighbor = map.get(src);

        for (String key : curNeighbor.keySet()) {
            if (visited.contains(key)) {
                continue;
            }
            if (tgt.equals(key)) {
                return num * curNeighbor.get(key);
            } else {
                double res = dfs(map, key, tgt, num * curNeighbor.get(key), visited);
                if (res != -1) {
                    return res;
                }
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int n = queries.size();
        double[]res = new double[n];
        // make graph
        Map<String, Map<String, Double>>map = new HashMap<>();

        int index = 0;
        for (List<String>equ : equations) {
            String src = equ.get(0);
            String tgt = equ.get(1);
            double value = values[index++];

            map.putIfAbsent(src, new HashMap<>());
            map.get(src).put(tgt, value);

            map.putIfAbsent(tgt, new HashMap<>());
            map.get(tgt).put(src, 1 / value);
        }
        // dfs
        index = 0;
        for (List<String>query : queries) {
            double num = 1;
            Set<String>visited = new HashSet<>();
            double dist = dfs(map, query.get(0), query.get(1), num, visited);
            res[index++] = dist;
        }
        //
        return res;
    }

    public static void main(String[] args) {

        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );


        Solution sol = new Solution();
        double[]res = sol.calcEquation(equations, values, queries);

        for (double num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


