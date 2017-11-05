package index.questions;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class 顺时针打印矩阵 {

    public static void main(String[] args) {
        int[] l1 = {1, 2, 3, 4, 5};
        int[] l2 = {6, 7, 8, 9, 10};
        int[] l3 = {11, 12, 13, 14, 15};
        int[] l4 = {16, 17, 18, 19, 20};
        int[] l5 = {21, 22, 23, 24, 25};
        int[][] m1 = {l1, l2,};

        print(m1);

    }

    public static void print(int[][] matrix) {
        /** 每次循环起始坐标 */
        int startx = 0, starty = 0;
        int endx = 0, endy = 0;

        int xlen = matrix[0].length;
        int ylen = matrix.length;

        endx = xlen - 1;
        endy = ylen - 1;

        while (2 * startx < xlen && 2 * starty < ylen) {

            //向右
            if (startx <= endx) {
                for (int i = startx; i <= endx; i++) {
                    System.out.print(matrix[starty][i]);
                    System.out.print(",");
                }
            }
            System.out.println();

            //向下
            if (starty + 1 <= endy) {
                for (int i = starty + 1; i <= endy; i++) {
                    System.out.print(matrix[i][xlen - startx - 1]);
                    System.out.print(",");
                }
            }
            System.out.println();

            //向左
            if (endx - 1 >= startx) {
                for (int i = endx - 1; i >= startx; i--) {
                    System.out.print(matrix[endy][i]);
                    System.out.print(",");
                }
            }
            System.out.println();

            //向上
            if (endy - 1 >= starty + 1) {
                for (int i = endy - 1; i >= starty + 1; i--) {
                    System.out.print(matrix[i][startx]);
                    System.out.print(",");
                }
            }
            System.out.println();

            startx++;
            starty++;
            endx--;
            endy--;

        }


    }


}
