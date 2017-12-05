package index.综合题系列1;

/**
 * Created by wangzhe.bj on 2017/12/5.
 */
public class 矩阵0转换1 {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0, 1, 1,},
                {0, 0, 1, 1, 0,},
                {0, 0, 1, 0, 0,},
                {0, 0, 0, 0, 0,},
        };
        turn0to1(arr);

    }

    public static void turn0to1(int[][] matrix) {
        int minLine = matrix.length - 1, minCol = matrix.length - 1;
        int maxLine = 0, maxCol = 0;

        for (int line = 0; line < matrix.length; line++) {
            for (int col = 0; col < matrix[line].length; col++) {
                if (matrix[line][col] == 1) {
                    minLine = Math.min(minLine, line);
                    minCol = Math.min(minCol, col);

                    maxLine = Math.max(maxLine, line);
                    maxCol = Math.max(maxCol, col);
                }

            }
        }

        for (int line = minLine; line <= maxLine; line++) {
            for (int col = minCol; col <= maxCol; col++) {
                if (matrix[line][col] == 0) {
                    matrix[line][col] = 1;
                }
            }
        }

        for (int line = 0; line < matrix.length; line++) {
            for (int col = 0; col < matrix[line].length; col++) {
                System.out.print(matrix[line][col] + " ");

            }
            System.out.println();
        }
    }

}
