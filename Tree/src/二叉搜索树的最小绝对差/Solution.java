package 二叉搜索树的最小绝对差;

class Solution {
    // 记住了 二叉搜索树是有序的
    int ret;
    TreeNode pre;
    public void midTraversal(TreeNode node) {

        if (node == null) {
            return;
        }
        midTraversal(node.left);
        //
        if (pre == null) {
            pre = node;
        } else {
            ret = Math.min(ret, node.val - pre.val);
            pre = node;
        }
        //
        midTraversal(node.right);
    }
    public int getMinimumDifference(TreeNode root) {

        ret = Integer.MAX_VALUE;
        pre = null;

        midTraversal(root);

        return ret;
    }
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(236);
        TreeNode t2 = new TreeNode(104);
        TreeNode t3 = new TreeNode(701);
        TreeNode t4 = new TreeNode(227);
        TreeNode t5 = new TreeNode(911);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.right = t5;

        Solution sol = new Solution();
        int ret = sol.getMinimumDifference(t1);

        System.out.println(ret);
    }
}

