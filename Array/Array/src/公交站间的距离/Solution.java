package 公交站间的距离;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int sum = 0, n = distance.length;

        int s, d;
        if (start < destination) {
            s = start;
            d = destination;
        } else {
            s = destination;
            d = start;
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (i >= s && i < d) {
                ret += distance[i];
            }
            sum += distance[i];
        }

        return Math.min(ret, sum - ret);
    }
    public static void main(String[] args) {

        int[]distance = {1,2,3,4};
        int start = 0, destination = 2;

        Solution sol = new Solution();
        int ret = sol.distanceBetweenBusStops(distance, start, destination);

        System.out.println(ret);
    }
}