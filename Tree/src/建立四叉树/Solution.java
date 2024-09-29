package 建立四叉树;

class Solution {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    public Node helper(int[][]grid, int len, int xStart, int xEnd, int yStart, int yEnd) {
        if (len == 1) {
            boolean val = grid[xStart][yStart] == 1;
            return new Node(val, true);
        }
        //
        boolean isAllTheSame = true;
        int firstNum = grid[xStart][yStart];
        outer:
        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd ; j++) {
                if (grid[i][j] != firstNum) {
                    isAllTheSame = false;
                    break outer;
                }
            }
        }
        if (isAllTheSame) {
            return new Node(firstNum == 1, true);
        }
        int subLen = len / 2;

        Node node = new Node(true, false);
        node.topLeft = helper(grid, subLen, xStart, xStart + subLen - 1, yStart, yStart + subLen - 1);
        node.topRight = helper(grid, subLen, xStart, xStart + subLen - 1, yStart + subLen, yEnd);
        node.bottomLeft = helper(grid, subLen, xStart + subLen, xEnd, yStart, yStart + subLen - 1);
        node.bottomRight = helper(grid, subLen, xStart + subLen, xEnd, yStart + subLen, yEnd);

        return node;
    }
    public Node construct(int[][] grid) {

        int n = grid.length;
        return helper(grid, n, 0, n - 1, 0, n - 1);
    }
    public static void main(String[] args){

        int[][] grid = {{0, 1}, {1, 0}};

        Solution sol = new Solution();
        Node res = sol.construct(grid);
    }
}

