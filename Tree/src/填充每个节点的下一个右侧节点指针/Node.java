package 填充每个节点的下一个右侧节点指针;

public class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node() {}
    Node(int val) {
        this.val = val;
        this.next = null;
        this.left = null;
        this.right = null;
    }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}