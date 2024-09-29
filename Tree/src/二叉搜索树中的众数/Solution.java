package 二叉搜索树中的众数;

import java.util.*;

class Solution {
    // Method 1
    Map<Integer, Integer> map;
    public void midTraversal(TreeNode node) {

        if (node == null) {
            return;
        }
        midTraversal(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        midTraversal(node.right);
    }
    public int[] findMode(TreeNode root) {

        map = new HashMap<>();
        midTraversal(root);
        PriorityQueue<Map.Entry<Integer, Integer>>pq = new PriorityQueue<>((a, b)->b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer>entry : map.entrySet()) {
            pq.add(entry);
        }
        Queue<Map.Entry<Integer, Integer>>queue = new LinkedList<>();
        queue.add(pq.poll());
        while (!pq.isEmpty() && pq.peek().getValue() == queue.peek().getValue()) {
            queue.add(pq.poll());
        }

        int n = queue.size();
        int[]ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = queue.poll().getKey();
        }

        return ret;
    }

    // Method 2
    List<Integer>list;
    TreeNode pre;
    int cnt;
    int maxCnt;
    public void midTraversal2(TreeNode node) {

        if (node == null) {
            return;
        }
        midTraversal2(node.left);

        if (pre == null) {
            cnt = 1;
        } else if (node.val == pre.val) {
            cnt++;
        } else {
            cnt = 1;
        }

        if (cnt > maxCnt) {
            list.clear();
            list.add(node.val);
            maxCnt = cnt;
        } else if (cnt == maxCnt) {
            list.add(node.val);
        }
        pre = node;

        midTraversal2(node.right);
    }
    public int[] findMode2(TreeNode root) {

        list = new LinkedList<>();
        pre = null;
        cnt = 0;
        maxCnt = Integer.MIN_VALUE;

        midTraversal2(root);

        int n = list.size();
        int[]ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);

        t1.right = t2;

        Solution sol = new Solution();
        int ret[] = sol.findMode2(t1);

        for (Integer item : ret) {
            System.out.println(item);
        }
        System.out.println();
    }
}

