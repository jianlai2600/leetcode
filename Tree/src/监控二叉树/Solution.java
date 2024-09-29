package 监控二叉树;

class Solution {
    int ret = 0;

    public int traversal(TreeNode node) {

        if (node == null) {
            return 1;
        }

        int l = traversal(node.left);
        int r = traversal(node.right);

        // 0 means no cover
        // 1 means cover
        // 2 means monitor

        if (l == 1 && r == 1) {
            return 0;
        } else if (l == 0 || r == 0) {
            ret++;
            return 2;
        } else {
            return 1;
        }
    }
    public int minCameraCover(TreeNode root) {

        int num = traversal(root);
        if (num == 0) {
            ret++;
        }
        return ret;
    }

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(0);

        t1.right = t2;
        t2.right = t3;
        t3.right = t4;

        Solution sol = new Solution();
        int ret = sol.minCameraCover(t1);

        System.out.println(ret);
    }
}

