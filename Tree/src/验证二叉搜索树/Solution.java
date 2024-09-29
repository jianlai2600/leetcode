package 验证二叉搜索树;

class Solution {
    public boolean check(TreeNode node, long low, long up) {

        if (node == null) {
            return true;
        }
        if (node.val <= low || node.val >= up) {
            return false;
        }
        return check(node.left, low, node.val) && check(node.right, node.val, up);
    }
    public boolean isValidBST(TreeNode root) {

        return check(root.left, Long.MIN_VALUE, root.val) && check(root.right, root.val, Long.MAX_VALUE);
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(-2147483648);
        TreeNode t2 = new TreeNode(2147483647);

        t1.right = t2;

        Solution sol = new Solution();
        boolean ret = sol.isValidBST(t1);

        System.out.println(ret);
    }
}

