package 二叉树的层序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if (root.equals(null))return ret;
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

        List<List<Integer>> ret = Solution.levelOrder(t1);

        for (List<Integer> innerList : ret) {
            for (Integer element : innerList) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

