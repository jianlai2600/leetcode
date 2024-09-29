package 层序遍历;

import java.util.*;

class Solution {

    public static List<List<Integer>> ret = new ArrayList<List<Integer>>();
    public void levelorderTraversal(TreeNode root) {

        Queue<TreeNode>que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer>tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.remove();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
                tmp.add(node.val);
            }
            ret.add(tmp);
        }
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;

        Solution sol = new Solution();

        sol.levelorderTraversal(t1);

        for (List<Integer> row : ret) {
            for (Integer item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}

