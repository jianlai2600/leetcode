package Databrick;

import java.util.*;

public class PlaceLamp {
    public static int solution(int[] objects, int radius) {

        int maxIlluminated = 0;
        int bestCoordinate = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int start = objects[0], end = objects[objects.length - 1];
        int curPoint = 0;

        int leftPoint = 0;

        for (int i = start; i <= end; i++) {

            if (i == objects[right]) {
                curPoint++;
                right++;
            }
            leftPoint = i - 2 * radius;

            if (objects[left] < leftPoint) {
                curPoint--;
                left++;
            }
            // If this position has more illuminated objects or is at a smaller coordinate
            if (curPoint > maxIlluminated) {
                maxIlluminated = curPoint;
                bestCoordinate = i - radius;
            }
        }

        return bestCoordinate;
    }

    public static void main(String[] args) {
        int[] objects = {-5, 3, 4, 9};
        int radius = 5;

        System.out.println(solution(objects, radius));  // Output should be -1
    }
}