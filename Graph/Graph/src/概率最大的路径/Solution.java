package 概率最大的路径;


import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int node;
        double probability;
        Pair(double probability, int node) {
            this.probability = probability;
            this.node = node;
        }
        public int compareTo(Pair p2) {
            if (this.probability == p2.probability) {
                return this.node - p2.node;
            } else {
                return this.probability - p2.probability > 0 ? -1 : 1;
            }
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<Pair>>graph = new ArrayList<List<Pair>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[]edge = edges[i];
            graph.get(edge[0]).add(new Pair(succProb[i], edge[1]));
            graph.get(edge[1]).add(new Pair(succProb[i], edge[0]));
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.offer(new Pair(1, start_node));

        double[]ret = new double[n];
        ret[start_node] = 1;

        while (!pq.isEmpty()) {
            Pair curPair = pq.poll();
            double curProbability = curPair.probability;
            int curNode = curPair.node;

            if (curProbability < ret[curNode]) {
                continue;
            }

            for (Pair neighbor : graph.get(curNode)) {
                double nextProbability = neighbor.probability;
                int nextNode = neighbor.node;

                if (ret[curNode] * nextProbability > ret[nextNode]) {
                    ret[nextNode] = ret[curNode] * nextProbability;
                    pq.offer(new Pair(ret[nextNode], nextNode));
                }
            }
        }

        return ret[end_node];
    }
    public static void main(String[] args) {

        int n = 3, start = 0, end = 2;
        int[][]edges = {{0, 1}, {1, 2}, {0, 2}};
        double[]succProb = {0.5, 0.5, 0.2};

        Solution sol = new Solution();
        double ret = sol.maxProbability(n, edges, succProb, start, end);

        System.out.println(ret);
    }
}