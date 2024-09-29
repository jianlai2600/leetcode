package 填充每个节点的下一个右侧节点指针;

import 层序遍历.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                Node node = que.poll();
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
                if (i < n - 1) {
                    node.next = que.peek();
                }
            }
        }
        return root;
    }
    public static void main(String[] args){

        Node t1 = new Node(1);
        Node t2 = new Node(2);
        Node t3 = new Node(3);

        t1.left = t2;
        t1.right = t3;

        Solution sol = new Solution();
        Node ret = sol.connect(t1);

        System.out.println(ret.val);
    }
}

