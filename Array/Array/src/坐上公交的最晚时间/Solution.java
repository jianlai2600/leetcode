package 坐上公交的最晚时间;

import java.util.Arrays;

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        int ret = -1;

        Arrays.sort(buses);
        Arrays.sort(passengers);

        int busLen = buses.length, passengerLen = passengers.length;
        int index = 0;

        int count = 0;

        for (int i = 0; i < busLen; i++) {
            int busTime = buses[i];
            count = capacity;

            while (index < passengerLen && passengers[index] <= busTime && count > 0) {
                count--;
                index++;
            }
        }
        // 寻找插队时机

        index--;

        int ans = count > 0 ? buses[busLen - 1] : passengers[index];

        while (index >= 0 && ans == passengers[index]) {
            index--;
            ans--;
        }

        return ans;
    }
    public static void main(String[] args) {

        int[] buses = {10,20}, passengers = {2,17,18,19};
        int capacity = 2;

        Solution sol = new Solution();
        int ret = sol.latestTimeCatchTheBus(buses, passengers, capacity);

        System.out.println(ret);
    }
}