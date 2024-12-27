package Databrick;

import static org.junit.Assert.assertEquals;

import Databrick.PlaceLamp;
import org.junit.Test;

public class PlaceLampTest {

    @Test
    public void testBasicCase() {
        int[] objects = {-5, 3, 4, 9};
        int radius = 5;
        int expected = -1;
        assertEquals(expected, PlaceLamp.solution(objects, radius));
    }

    @Test
    public void testAllObjectsInRange() {
        int[] objects = {1, 2, 3, 4, 5};
        int radius = 10;
        int expected = -5; // 所有对象都在灯的范围内，最小的坐标是 1
        assertEquals(expected, PlaceLamp.solution(objects, radius));
    }

    @Test
    public void testSingleObject() {
        int[] objects = {100};
        int radius = 5;
        int expected = 95; // 只有一个对象，灯应该放在 100
        assertEquals(expected, PlaceLamp.solution(objects, radius));
    }

    @Test
    public void testCannotIlluminateAllObjects() {
        int[] objects = {-10, 0, 10};
        int radius = 5;
        int expected = -5; // 最佳位置是 0，可以照亮对象 0
        assertEquals(expected, PlaceLamp.solution(objects, radius));
    }

    @Test
    public void testMultipleOptimalSolutions() {
        int[] objects = {-10, -5, 0, 5, 10};
        int radius = 5;
        int expected = -5; // 有多个最佳位置，返回最小的坐标 -5
        assertEquals(expected, PlaceLamp.solution(objects, radius));
    }

    @Test
    public void testZeroRadius() {
        int[] objects = {1, 5, 9};
        int radius = 0;
        int expected = 1; // 半径为 0 时，只能照亮一个对象，选择最小的对象坐标
        assertEquals(expected, PlaceLamp.solution(objects, radius));
    }
}
