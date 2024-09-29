package 二叉搜索树迭代器;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BSTIterator {
    int size;
    int index;
    List<Integer>list;
    public void midTraversal(TreeNode node) {

        if (node == null) {
            return;
        }
        midTraversal(node.left);
        list.add(node.val);
        midTraversal(node.right);
    }
    public BSTIterator(TreeNode root) {

        list = new LinkedList<>();
        midTraversal(root);
        size = list.size();
        index = 0;
    }

    public int next() {

        int val = list.get(index++);
        return val;
    }

    public boolean hasNext() {
        return index < size;
    }
}

