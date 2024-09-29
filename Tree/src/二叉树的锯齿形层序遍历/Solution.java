package 二叉树的锯齿形层序遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>>ret = new LinkedList<>();
        List<Integer>row = new LinkedList<>();
        Queue<TreeNode>queue = new LinkedList<>();

        if (root == null) {
            return ret;
        }

        queue.add(root);

        boolean flag = false;

        while (!queue.isEmpty()) {

            int size = queue.size();
            row.clear();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                row.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag) {
                flag = false;
                row = row.reversed();
            } else {
                flag = true;
            }
            ret.add(new LinkedList<>(row));
        }

        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        Solution sol = new Solution();
        List<List<Integer>> ret = sol.zigzagLevelOrder(t1);

        for (List<Integer>row : ret) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

