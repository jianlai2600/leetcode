package Dota2参议院;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {

        int n = senate.length();
        Queue<Integer>queue1 = new LinkedList<>();
        Queue<Integer>queue2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                queue1.add(i);
            } else {
                queue2.add(i);
            }
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int raIndex = queue1.poll(), diIndex = queue2.poll();
            if (raIndex < diIndex) {
                queue1.add(raIndex + n);
            } else {
                queue2.add(diIndex + n);
            }
        }
        return !queue1.isEmpty() ? "Radiant" : "Dire";
    }
    public static void main(String[] args) {

        String senate = "RD";

        Solution sol = new Solution();
        String ret = sol.predictPartyVictory(senate);

        System.out.println(ret);
    }
}

