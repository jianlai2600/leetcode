package 根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        int[][]ret = new int[people.length][2];

        Arrays.sort(people, (a, b)->{
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        ArrayList<int[]> list = new ArrayList<>();

        for (int[]person : people) {
            list.add(person[1], person);
        }

        int i = 0;
        for (int[]person : list) {
            ret[i++] = person;
        }

        return ret;
    }
    public static void main(String[] args) {

        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        Solution sol = new Solution();
        int[][] ret = sol.reconstructQueue(people);

        for (int[] person : ret) {
            System.out.println(Arrays.toString(person));
        }
    }
}

