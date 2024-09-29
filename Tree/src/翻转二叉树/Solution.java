package 翻转二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public void levelOrderPrint(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> vec = new ArrayList<>();
            int size = q.size();
            int i = 1;
            while (i <= size){
                TreeNode tmp = q.poll();
                vec.add(tmp.val);
                if (tmp.left != null)q.offer(tmp.left);
                if (tmp.right != null)q.offer(tmp.right);
                i++;
            }
            ret.add(vec);
        }

        for (List<Integer> innerList : ret) {
            for (Integer element : innerList) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return root;
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
        t4.left = t6;

        Solution sol = new Solution();
        sol.levelOrderPrint(t1);

        t1 = sol.invertTree(t1);
        sol.levelOrderPrint(t1);
    }
}

