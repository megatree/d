package index.leetcode_cn.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-05-14.
 */
public class 旋转图像 {

    @Test
    public void go() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                System.out.print(matrix[i][i1] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 每一圈的四个位置依次swap
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (matrix == null || n < 2) {
            return;
        }

        int cycle = n / 2;
        for (int i = 0; i < cycle; i++) {
            for (int j = 0; j < n - 2 * i - 1; j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - i - 1 - j][i];
                matrix[n - i - 1 - j][i] = matrix[n - i - 1][n - i - 1 - j];
                matrix[n - i - 1][n - i - 1 - j] = matrix[i + j][n - i - 1];
                matrix[i + j][n - i - 1] = temp;
            }
        }

    }


    /**
     * 94.70 %
     * 时快时慢
     *
     * @param matrix
     */
    public void rotate_2(int[][] matrix) {
        int n = matrix.length;
        if (matrix == null || n < 2) {
            return;
        }

        //用辅助数组旋转
        //或者写个方法做矩阵遍历映射数组，原矩阵旋转
        int[] arr = new int[n * 4 - 4];

        //圈数
        int cycle = n / 2;
        for (int i = 0; i < cycle; i++) {
            //使得每一圈遍历两遍
            //第一遍读数至数组
            //第二遍数组赋值至环
            for (int i1 = 0; i1 < 2; i1++) {
                //第一排左向右
                int idx = 0;
                for (int j = i; j < n - i; j++) {
                    //i,j
                    int s = matrix[i][j];

                    if (i1 == 0) {
                        putArray(arr, s, idx++);
                    } else {
                        matrix[i][j] = putMatrix(matrix, i, idx++, arr);
                    }
                }

                //最右列向下
                for (int j = i + 1; j < n - i; j++) {
                    //j,n-1-i
                    int s = matrix[j][n - 1 - i];

                    if (i1 == 0) {
                        putArray(arr, s, idx++);
                    } else {
                        matrix[j][n - 1 - i] = putMatrix(matrix, i, idx++, arr);
                    }
                }

                //最下排从右向左
                for (int j = n - 2 - i; j >= i; j--) {
                    //n-1-i,j
                    int s = matrix[n - 1 - i][j];

                    if (i1 == 0) {
                        putArray(arr, s, idx++);
                    } else {
                        matrix[n - 1 - i][j] = putMatrix(matrix, i, idx++, arr);
                    }
                }

                //最左列向上
                for (int j = n - 2 - i; j > i; j--) {
                    //j,i
                    int s = matrix[j][i];

                    if (i1 == 0) {
                        putArray(arr, s, idx++);
                    } else {
                        matrix[j][i] = putMatrix(matrix, i, idx++, arr);
                    }
                }
            }
        }


    }

    /**
     * 按遍历顺序读数至数组
     *
     * @param arr
     * @param data
     * @param index
     */
    public void putArray(int[] arr, int data, int index) {
        arr[index] = data;
    }

    /**
     * 从数组正确位置读数，写至矩阵(根据矩阵)
     *
     * @param matrix
     * @param cycle
     * @param arr
     * @Param idx   //第几位数
     */
    public int putMatrix(int[][] matrix, int cycle, int idx, int[] arr) {
        //当前圈的阶数
        int n = matrix.length - 2 * cycle;
        //当前圈数组长度
        int length = 4 * n - 4;
        int index = (length - (n - 1) + idx) % length;

        return arr[index];
    }


}
