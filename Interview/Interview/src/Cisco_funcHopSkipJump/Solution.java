package Cisco_funcHopSkipJump;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * matrix, represents the elements in each cell of the matrix of size N*M.
 */
public class Solution
{
    static int[][]dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void  funcHopSkipJump(int[][] matrix)
    {
        // Write your code here
        List<Integer>list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, down = m - 1, left = 0, right = n - 1;
        int x = 0, y = 0;

        int dirIndex = 0;
        while (top <= down && left <= right) {
            if (x >= top && x <= down && y >= left && y <= right) {
                list.add(matrix[x][y]);
            }
            x += dir[dirIndex][0];
            y += dir[dirIndex][1];

            if (x > down) {
                x = down;
                left++;
                y = left;
                dirIndex = (dirIndex + 1) % 4;
            } else if (x < top) {
                x = top;
                right--;
                y = right;
                dirIndex = (dirIndex + 1) % 4;
            } else if (y < left) {
                y = left;
                top++;
                x = top;
                dirIndex = (dirIndex + 1) % 4;
            } else if (y > right) {
                y = right;
                down--;
                x = down;
                dirIndex = (dirIndex + 1) % 4;
            }
        }
        int num = 0;
        for (int i = 0; i < list.size(); i = i + 2) {
            num = list.get(i);
        }
        System.out.println(num);
    }

    public static void main(String[] args)
    {
        // 样例矩阵输入
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 打印输入矩阵
        System.out.println("Input Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 调用函数
        System.out.println("\nResult:");
        funcHopSkipJump(matrix);
    }
}