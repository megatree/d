package index.amazon_oa;

import org.junit.Test;

/**
 * 一个二维数组，0 1 分别表示黑白。其中横竖斜线邻接，认为其是完整一块。
 * 现在计算有多少黑块
 */
public class BlackAndWhite {

    int[][] directs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    @Test
    public void go() {
        int[][] grid = {
                {1, 1, 0, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 0},
        };
        System.out.println(regionCount(grid));
    }

    /**
     * @param matrix
     * @return
     */
    public int regionCount(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                    dfs(matrix, rows, cols, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] matrix, int rows, int cols, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] == 1) {
            //越界 且 白
            return;
        }


        matrix[i][j] = 1;

        for (int[] direct : directs) {
            //8个方向
            dfs(matrix, rows, cols, i + direct[0], j + direct[1]);
        }
    }

}
