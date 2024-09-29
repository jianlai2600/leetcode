package 左叶子之和;

class Solution {
    int ret;
    public void traversal(TreeNode node, int left) {

        if (node == null) {
            return;
        }
        if (left == 1 && node.left == null && node.right == null) {
            ret += node.val;
            return;
        }
        traversal(node.left, 1);
        traversal(node.right, 0);
    }
    public int sumOfLeftLeaves(TreeNode root) {

        ret = 0;

        traversal(root, 0);

        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        Solution sol = new Solution();
        int ret = sol.sumOfLeftLeaves(t1);

        System.out.println(ret);
    }
}

