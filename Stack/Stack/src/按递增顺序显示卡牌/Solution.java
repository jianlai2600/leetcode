package 按递增顺序显示卡牌;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        int[]ans = new int[n];

        Deque<Integer>deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(i);
        }

        Arrays.sort(deck);

        for (Integer num : deck) {
            ans[deque.pollFirst()] = num;
            if (!deque.isEmpty()) {
                deque.add(deque.pollFirst());
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] deck = {17,13,11,2,3,5,7};

        Solution sol = new Solution();
        int[]ret = sol.deckRevealedIncreasing(deck);

        for (Integer num : ret) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
