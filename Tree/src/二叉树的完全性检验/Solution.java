package 二叉树的完全性检验;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    // Method 2
    public boolean isCompleteTree2(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }

        return nodes.get(i-1).code == nodes.size();
    }

    class ANode {  // Annotated Node
        TreeNode node;
        int code;
        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    // Method 1
    static final int sn = -1;

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer>tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.remove();

                if (node.val == sn) {
                    while (!que.isEmpty()) {
                        TreeNode ln = que.poll();
                        if (ln.val != sn) {
                            return false;
                        }
                    }
                    return true;
                }
                if (node.left != null) {
                    que.offer(node.left);
                } else {
                    TreeNode nn = new TreeNode(sn);
                    que.offer(nn);
                }
                if (node.right != null) {
                    que.offer(node.right);
                } else {
                    TreeNode nn = new TreeNode(sn);
                    que.offer(nn);
                }
                tmp.add(node.val);
            }
        }
        return true;
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
        t3.left = t6;

        Solution sol = new Solution();

        boolean res = sol.isCompleteTree(t1);

        System.out.println(res);

    }
}

