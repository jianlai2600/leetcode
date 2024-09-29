package 公交路线;

import java.util.*;

class Solution {
//    public Map<Set<Integer>, List<Set<Integer>>> makeGraph(int[][] routes) {
//
//        Map<Set<Integer>, List<Set<Integer>>>graph = new HashMap<>();
//        Map<Integer, List<Set<Integer>>>point2Node = new HashMap<>();
//
//        for (int[]route : routes) {
//            Set<Integer>tmpSet = new HashSet<>();
//            for (Integer point : route) {
//                tmpSet.add(point);
//            }
//            for (Integer point : tmpSet) {
//                point2Node.putIfAbsent(point, new ArrayList<>());
//                point2Node.get(point).add(tmpSet);
//            }
//        }
//
//        for (Integer key : point2Node.keySet()) {
//            List<Set<Integer>> line = point2Node.get(key);
//            for (int i = 0; i < line.size(); i++) {
//                for (int j = i + 1; j < line.size(); j++) {
//                    Set<Integer>first = line.get(i);
//                    Set<Integer>second = line.get(j);
//                    graph.putIfAbsent(first, new ArrayList<>());
//                    graph.putIfAbsent(second, new ArrayList<>());
//                    graph.get(first).add(second);
//                    graph.get(second).add(first);
//                }
//            }
//        }
//        return graph;
//    }
//    public int bfs(Set<Integer>node, int target, Map<Set<Integer>, List<Set<Integer>>>graph) {
//
//        int ret = 1;
//
//        Queue<Set<Integer>>queue = new LinkedList<>();
//        Set<Set<Integer>>set = new HashSet<>();
//
//        queue.add(node);
//        set.add(node);
//
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Set<Integer>curNode = queue.poll();
//
//                if (curNode.contains(target)) {
//                    return ret;
//                }
//                for (Set<Integer>neighbors : graph.get(curNode)) {
//                    if (!set.contains(neighbors)) {
//                        queue.add(neighbors);
//                        set.add(neighbors);
//                    }
//                }
//            }
//            ret++;
//        }
//        return -1;
//    }
//    public int numBusesToDestination(int[][] routes, int source, int target) {
//
//        if (source == target) {
//            return 0;
//        }
//
//        Map<Set<Integer>, List<Set<Integer>>>graph = makeGraph(routes);
//        int ret = Integer.MAX_VALUE;
//
//        for (Set<Integer>node : graph.keySet()) {
//            if (node.contains(source)) {
//                int result = bfs(node, target, graph);
//                ret = Math.min(result, ret);
//            }
//        }
//
//        return ret == Integer.MAX_VALUE ? -1 : ret;
//    }
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>>stationToBus = new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            for (int station : routes[bus]) {
                if (!stationToBus.containsKey(station)) {
                    stationToBus.put(station, new ArrayList<>());
                }
                stationToBus.get(station).add(bus);
            }
        }

        Queue<Integer>queue = new LinkedList<>();
        queue.add(source);

        int[]visited = new int[routes.length];

        int ret = 0;

        while (!queue.isEmpty()) {

            ret++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int station = queue.poll();

                List<Integer>busList = stationToBus.get(station);
                if (busList == null) {
                    continue;
                }
                for (int bus : stationToBus.get(station)) {
                    if (visited[bus] == 1) continue;

                    visited[bus] = 1;
                    for (int newStation : routes[bus]) {
                        if (newStation == target) {
                            return ret;
                        }
                        if (newStation == station) {
                            continue;
                        }
                        queue.offer(newStation);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] routes = {
                {1,2,7},
                {3,6,7}
        };
        int source = 1, target = 6;

        Solution sol = new Solution();
        int ret = sol.numBusesToDestination(routes, source, target);

        System.out.println(ret);
    }
}


