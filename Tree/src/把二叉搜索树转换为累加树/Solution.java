package 把二叉搜索树转换为累加树;

class Solution {
    TreeNode pre;
    public void traversal(TreeNode node) {

        if (node == null) {
            return;
        }
        traversal(node.right);
        if (pre != null) {
            node.val += pre.val;
            pre = node;
        } else {
            pre = node;
        }
        traversal(node.left);
    }
    public TreeNode convertBST(TreeNode root) {

        pre = null;
        traversal(root);

        return root;
    }
    public static void main(String[] args){

        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(3);
        TreeNode t9 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.right = t8;
        t7.right = t9;

        Solution sol = new Solution();
        TreeNode ret = sol.convertBST(t1);

        System.out.println(ret.val);
    }
}

