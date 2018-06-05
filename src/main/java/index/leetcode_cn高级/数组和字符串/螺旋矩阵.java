package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhe.bj on 2018-06-05.
 */
public class 螺旋矩阵 {

    @Test
    public void go() {
        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] m2 = {
                {1, 2, 3},
                {4, 5, 6},
        };

        int[][] m3 = {
                {1, 2},
                {4, 5},
                {7, 8}
        };

        int[][] m4 = {
                {1, 2, 3},
        };

        int[][] m5 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

//        System.out.println(spiralOrder(m1));
//        System.out.println(spiralOrder(m2));
//        System.out.println(spiralOrder(m3));
//        System.out.println(spiralOrder(m4));
        System.out.println(spiralOrder(m5));
    }

    /**
     * 问题在于，m*n内层不规则
     * 存在bug
     *
     * @param matrix
     * @return
     */
    @Deprecated
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        //最外层第一圈
        int level = 0;
        //坐标
        int r = 0, c = 0;
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }

        while (r < row - level && c < col - level) {

            while (c < col - level) {
                list.add(matrix[r][c]);
                c++;
            }
            c--;
            r++;
            while (r < row - level) {
                list.add(matrix[r][c]);
                r++;
            }
            c--;
            r--;
            while (c >= level && c < col - level) {
                list.add(matrix[r][c]);
                c--;
            }
            r--;
            c++;

            while (r > level && r < row - level) {
                list.add(matrix[r][c]);
                r--;
            }
            r++;
            c++;

            level++;
        }
        return list;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int row = matrix.length;
        int col = matrix[0].length;



    }
}
