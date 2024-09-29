package 二叉树的所有路径;

import java.lang.module.InvalidModuleDescriptorException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    List<String>ret;
    List<Integer>ans;
    public String getString() {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ans.size(); i++) {
            if (i != ans.size() - 1) {
                sb.append(ans.get(i) + "->");
            } else {
                sb.append(ans.get(i));
            }
        }
        return sb.toString();
    }
    public void backTracking(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            ans.add(node.val);
            ret.add(getString());
            return;
        }
        ans.add(node.val);
        if (node.left != null) {
            backTracking(node.left);
            ans.removeLast();
        }
        if (node.right != null) {
            backTracking(node.right);
            ans.removeLast();
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {

        ret = new LinkedList<>();
        ans = new LinkedList<>();

        backTracking(root);

        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;

        Solution sol = new Solution();
        List<String> ret = sol.binaryTreePaths(t1);

        for (String s : ret) {
            System.out.println(s);
        }
        System.out.println();
    }
}

