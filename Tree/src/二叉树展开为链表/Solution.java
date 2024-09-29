package 二叉树展开为链表;

import java.util.*;

class Solution {

    public void preorderTraversal(TreeNode root, List l)
    {
        if (root != null)
        {
            l.add(root);
            preorderTraversal(root.left, l);
            preorderTraversal(root.right, l);
        }
    }

    public void flatten2(TreeNode root)
    {
        List<TreeNode> l = new ArrayList<TreeNode>();
        preorderTraversal(root, l);

        for (int i = 1; i < l.size(); i++)
        {
            TreeNode pre = l.get(i - 1);
            TreeNode cur = l.get(i);
            pre.right = cur;
            pre.left = null;
        }

    }
    public void flatten(TreeNode root)
    {
        if (root == null)return;

        Deque<TreeNode>stack = new LinkedList<TreeNode>();
        stack.push(root);

        TreeNode pre = null;

        while(!stack.isEmpty())
        {
            TreeNode cur = stack.pop();

            if (pre != null)
            {
                pre.left = null;
                pre.right = cur;
            }

            TreeNode left = cur.left, right = cur.right;
            if (right != null)stack.push(right);
            if (left != null)stack.push(left);

            pre = cur;
        }

    }
//    public void flatten(TreeNode root) {
//        if (root == null)return;
//
//        TreeNode l = root.left;
//        TreeNode r = root.right;
//
//        TreeNode cur = root;
//
//        if (l != null)
//        {
//            cur.left = null;
//            flatten(l);
//            cur.right = l;
//            while (cur.right != null)
//            {
//                cur = cur.right;
//            }
//        }
//
//        if (r != null)
//        {
//            cur.left = null;
//            flatten(r);
//            cur.right = r;
//        }
//    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;

        Solution sol = new Solution();
        sol.flatten(t1);

        TreeNode cur = t1;
        while (cur != null)
        {
            System.out.print(cur.val + "->");
            cur = cur.right;
        }

    }
}

