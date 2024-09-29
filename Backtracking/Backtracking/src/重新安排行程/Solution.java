package 重新安排行程;

import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String>ret = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            map.computeIfAbsent(src, key->new PriorityQueue<>()).add(dst);
        }

        dfs("JFK");
        return ret;
    }

    private void dfs(String src) {
        PriorityQueue<String> neighbors = map.getOrDefault(src, new PriorityQueue<>());
        while (!neighbors.isEmpty()) {
            dfs(neighbors.poll());
        }
        ret.add(0, src); // Add the airport to the beginning of the list
    }

    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));

        Solution sol = new Solution();
        List<String>ret = sol.findItinerary(tickets);

        for (String s : ret) {
            System.out.print(s + "->");
        }
        System.out.println();
    }
}