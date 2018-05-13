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

    }

    public void rotate(int[][] matrix) {
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

                    if (i1==0) {
                        putArray(arr, s, idx++);
                    }
                }

                //最右列向下
                for (int j = i + 1; j < n - i; j++) {
                    //j,n-1-i
                    int s = matrix[j][n - 1 - i];

                    if (i1==0) {
                        putArray(arr, s, idx++);
                    }
                }

                //最下排从右向左
                for (int j = n - 2 - i; j >= i; j--) {
                    //n-1-i,j
                    int s = matrix[n - 1 - i][j];

                    if (i1==0) {
                        putArray(arr, s, idx++);
                    }
                }

                //最左列向上
                for (int j = n - 2 - i; j > i; j--) {
                    //j,i
                    int s = matrix[j][i];

                    if (i1==0) {
                        putArray(arr, s, idx++);
                    }
                }

            }
            System.out.println(Arrays.toString(arr));
        }



    }

    /**
     * 按遍历顺序读数至数组
     * @param arr
     * @param data
     * @param index
     */
    public void putArray(int[] arr, int data, int index) {
        arr[index] = data;
    }

    /**
     * 从数组正确位置读数，写至矩阵(根据矩阵)
     * @param matrix
     * @param cycle
     * @Param idx   //第几位数
     * @param arr
     */
    public void putMatrix(int[][] matrix,int cycle,int idx,int[] arr){
        int n = matrix.length;


    }


}
