package 克隆图;


import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
class Solution {
    HashMap<Node, Node>visited = new HashMap<>();
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node copyNode = new Node(node.val, new ArrayList<>());
        visited.put(node, copyNode);

        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }

        return copyNode;
    }

    public Node cloneGraphDFS(Node node) {

        if (node == null) {
            return null;
        }

        visited.put(node, new Node(node.val, new ArrayList<>()));

        Queue<Node>queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();

            for (Node neighbor : tmpNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                }
                visited.get(tmpNode).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        List<Node>neighbor1 = new ArrayList<>();
        neighbor1.add(n2);
        neighbor1.add(n4);


        List<Node>neighbor2 = new ArrayList<>();
        neighbor2.add(n1);
        neighbor2.add(n3);

        List<Node>neighbor3 = new ArrayList<>();
        neighbor3.add(n2);
        neighbor3.add(n4);

        List<Node>neighbor4 = new ArrayList<>();
        neighbor4.add(n1);
        neighbor4.add(n3);

        Solution sol = new Solution();
        Node ret = sol.cloneGraph(n1);

        System.out.println(ret.val);
    }
}


