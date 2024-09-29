package 另一棵树的子树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ret = new ArrayList<>();

        if (root == null)return ret;

        Queue<TreeNode>q = new LinkedList<>();

        q.offer(root);

        int num;
        int flag = 0;
        while (!q.isEmpty())
        {
            num = q.size();
            for (int i = 0; i < num; i++)
            {
                TreeNode node = q.poll();
                flag = node.val;
                if (node.left != null)
                {
                    q.offer(node.left);
                }
                if (node.right != null)
                {
                    q.offer(node.right);
                }
            }
            ret.add(flag);

        }

        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.right = t5;

        Solution sol = new Solution();
        List<Integer> ret = sol.rightSideView(t1);

        System.out.println(ret);
    }
}

