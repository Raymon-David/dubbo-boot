package com.raymon.api.demo.leetcodeDemo;

import java.util.Arrays;

/**
 * @author ：raymon
 * @date ：Created in 2019/7/19 9:13
 * @description：给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 *
 & 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * @modified By：
 * @version: 1.0$
 */
public class RotateArray {

    public static void rotateArray(int[][] matrix) {

        int n = matrix.length;

        if (n <= 1) {
            return;
        }

        //旋转次数
        int count = n * n / 4;

        int x = 0;
        int y = 0;
        int z = 0;

        int x1, y1, x2, y2;

        for (int i = 0; i < count; i++) {
            if (z >= (n - 1) - 2 * x) {
                x += 1;
                z = 0;
            }
            y = z + x;
            z += 1;

            x1 = x;
            y1 = y;

            for (int j = 0; j < 3; j++) {
                x2 = n - 1 - y1;
                y2 = x1;

                matrix[x1][y1] = matrix[x2][y2] ^ matrix[x1][y1];
                matrix[x2][y2] = matrix[x1][y1] ^ matrix[x2][y2];
                matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];

                x1 = x2;
                y1 = y2;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {

        int[][] matrix = {
                                {1,2,3},
                                {4,5,6},
                                {7,8,9}
                                };

        System.out.println(Arrays.deepToString(matrix));
        rotateArray(matrix);
    }
}
