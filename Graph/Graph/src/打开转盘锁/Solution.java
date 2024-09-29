package 打开转盘锁;

import java.util.*;

class Solution {
    public char getPreChar(char c) {
        return c == '0' ? '9' : (char) (c - 1);
    }
    public char getPostChar(char c) {
        return c == '9' ? '0' : (char) (c + 1);
    }
    public List<String> getNeighbor(String s) {

        List<String>ret = new ArrayList<>();
        char[]arr = s.toCharArray();

        for (int i = 0; i < 4; i++) {

            char c = s.charAt(i);
            // pre
            arr[i] = getPreChar(c);
            ret.add(new String(arr));
            // post
            arr[i] = getPostChar(c);
            ret.add(new String(arr));

            arr[i] = c;
        }

        return ret;
    }
    public int openLock(String[] deadends, String target) {

        // Base Case
        int step = 0;

        Queue<String>queue = new LinkedList<>();
        Set<String>banned = new HashSet<>();
        Set<String>visited = new HashSet<>();
        for (String s : deadends) {
            banned.add(s);
        }
        queue.add("0000");

        if (banned.contains("0000")) {
            return -1;
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curCode = queue.poll();
                if (!visited.contains(curCode) && !banned.contains(curCode)) {
                    if (curCode.equals(target)) {
                        return step;
                    }
                    visited.add(curCode);
                    List<String>neighbors = getNeighbor(curCode);
                    queue.addAll(neighbors);
                }
            }
            step++;
        }

        return -1;
    }
    public static void main(String[] args) {

        String[]deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        Solution sol = new Solution();
        int ret = sol.openLock(deadends, target);

        System.out.println(ret);
    }
}


