package 迭代遍历;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {

    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return ret;
    }

    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode>stack = new Stack<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                ret.add(node.val);
                node = node.right;
            }
        }
        return ret;
    }

    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        Collections.reverse(ret);
        return ret;
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

        List<Integer> l1 = sol.preorderTraversal(t1);
        System.out.print("preorderTraversal\t");
        for (Integer item : l1) {
            System.out.print(item + "->");
        }
        System.out.println();

        List<Integer> l2 = sol.inorderTraversal(t1);
        System.out.print("inorderTraversal\t");
        for (Integer item : l2) {
            System.out.print(item + "->");
        }
        System.out.println();

        List<Integer> l3 = sol.postorderTraversal(t1);
        System.out.print("postorderTraversal\t");
        for (Integer item : l3) {
            System.out.print(item + "->");
        }
        System.out.println();

    }
}

