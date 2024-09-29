package 滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class PriorityQueue {
        Deque<Integer>queue;
        // Initial the PriorityQueue
        PriorityQueue() {
            queue = new LinkedList<>();
        }
        // Return the max value
        private int peek() {
            return queue.peek();
        }
        // Add item into the PriorityQueue
        private void add(int val) {
            while (!queue.isEmpty() && val > queue.getLast()) {
                queue.removeLast();
            }
            queue.add(val);
        }
        // Pop out the value if it is at the front
        private void pop(int val) {
            if (!queue.isEmpty() && queue.peek() == val) {
                queue.removeFirst();
            }
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[]ret = new int[n - k + 1];

        PriorityQueue pq = new PriorityQueue();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = 0; i + k <= n; i++) {
            ret[i] = pq.peek();
            pq.pop(nums[i]);
            if (i + k < n) {
                pq.add(nums[i + k]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Solution sol = new Solution();

        int[] ret = sol.maxSlidingWindow(nums, k);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}