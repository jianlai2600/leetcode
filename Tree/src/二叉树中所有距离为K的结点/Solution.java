package 二叉树中所有距离为K的结点;

import java.util.*;

class Solution {
    List<Integer>res;
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public void midTraversal(TreeNode node) {

        if (node.left != null) {
            map.putIfAbsent(node, new ArrayList<>());
            map.get(node).add(node.left);

            map.putIfAbsent(node.left, new ArrayList<>());
            map.get(node.left).add(node);
            midTraversal(node.left);
        }
        if (node.right != null) {
            map.putIfAbsent(node, new ArrayList<>());
            map.get(node).add(node.right);

            map.putIfAbsent(node.right, new ArrayList<>());
            map.get(node.right).add(node);
            midTraversal(node.right);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        res = new ArrayList<>();
        // make graph
        midTraversal(root);

        if (map.isEmpty()) {
            return res;
        }
        // bfs
        Queue<TreeNode>queue = new LinkedList<>();
        Set<TreeNode>set = new HashSet<>();
        queue.add(target);
        set.add(target);

        int dis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (dis == k) {
                    res.add(tmp.val);
                }
                for (TreeNode neighbor : map.get(tmp)) {
                    if (!set.contains(neighbor)) {
                        queue.add(neighbor);
                        set.add(neighbor);
                    }
                }
            }

            dis++;
        }
        //
        return res;
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;

        int k = 2;

        Solution sol = new Solution();
        List<Integer> res = sol.distanceK(t1, t2, k);

        for (Integer num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

