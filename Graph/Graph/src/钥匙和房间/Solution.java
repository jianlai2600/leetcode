package 钥匙和房间;

import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer>queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int curRoom = queue.poll();
            for (Integer neighbor : rooms.get(curRoom)) {
                if (neighbor != curRoom && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<List<Integer>>rooms = new ArrayList<>();

        rooms.add(new ArrayList<>(Arrays.asList(1)));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(3)));
        rooms.add(new ArrayList<>());

        Solution sol = new Solution();
        boolean ret = sol.canVisitAllRooms(rooms);

        System.out.println(ret);
    }
}


