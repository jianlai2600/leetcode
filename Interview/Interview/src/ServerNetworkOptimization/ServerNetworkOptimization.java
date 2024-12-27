package ServerNetworkOptimization;

import java.util.*;

class ServerNetworkOptimization {

    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            if (u != parent[u]) {
                parent[u] = find(parent[u]);  // path compression
            }
            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) return false;

            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }

    public static int minCostToConnectServers(int[] x, int[] y) {
        int n = x.length;
        List<Edge> edges = new ArrayList<>();

        // Create edges based on x coordinates
        List<int[]> xSorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            xSorted.add(new int[]{x[i], i});
        }
        xSorted.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < n; i++) {
            int u = xSorted.get(i - 1)[1];
            int v = xSorted.get(i)[1];
            int cost = Math.abs(x[u] - x[v]);
            edges.add(new Edge(u, v, cost));
        }

        // Create edges based on y coordinates
        List<int[]> ySorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ySorted.add(new int[]{y[i], i});
        }
        ySorted.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < n; i++) {
            int u = ySorted.get(i - 1)[1];
            int v = ySorted.get(i)[1];
            int cost = Math.abs(y[u] - y[v]);
            edges.add(new Edge(u, v, cost));
        }

        // Sort edges by cost
        Collections.sort(edges);

        // Kruskal's algorithm to find the MST
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                totalCost += edge.cost;
                edgesUsed++;
                if (edgesUsed == n - 1) break;  // MST is found
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] x = {2, 4, 8};
        int[] y = {6, 10, 9};

        int result = minCostToConnectServers(x, y);
        System.out.println("Minimum cost to connect all servers: " + result);
    }
}
