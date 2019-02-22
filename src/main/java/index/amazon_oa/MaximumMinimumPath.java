package index.amazon_oa;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2019-02-22.
 * <p>
 * 给一个矩阵,
 * <p>
 * 先找所有从左上到右下的path.
 * 找出每个path的最小值.
 * 找出这些最小值中的最大值.
 * 这题看着挺乱的, 给个例子就清楚了.
 * <p>
 * Java
 * {8,4,3,5}
 * {6,5,9,8}
 * 1
 * 2
 * {8,4,3,5}
 * {6,5,9,8}
 * 这个返回5
 * <p>
 * 所有的path:
 * <p>
 * 8->4->3->5->8 min:3
 * <p>
 * 8->4->3->9->8 min:3
 * <p>
 * 8->4->5->9->8 min:5
 * <p>
 * 8->6->5->9->8 min:5
 * <p>
 * Result = Math.max(3,3,5,5,) = 5
 */
public class MaximumMinimumPath {

    private int currentMin = Integer.MAX_VALUE;
    private int maxMin = Integer.MIN_VALUE;

    @Test
    public void test() {


    }

    /**
     * 由于每个点必由其上方或左方点经过，因此可以从顶点开始（不含），给每一个点设置为经过路径的最小值。
     * 设置规则为中上，中左分别取最小，然后最小值里取最大。
     * 这样设置到最后一个点，即为所求
     *
     * @param matrix
     * @return
     */
    public int maximumMinimumPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    //不含原点
                    continue;
                }

                int a = Integer.MAX_VALUE;
                int b = Integer.MIN_VALUE;

                if (i - 1 >= 0) {
                    a = Math.min(matrix[i][j], matrix[i - 1][j]);
                }
                if (j - 1 >= 0) {
                    b = Math.min(matrix[i][j], matrix[i][j - 1]);
                }
                matrix[i][j] = Math.max(a, b);
            }
        }
        return matrix[rows - 1][cols - 1];
    }

    /**
     * 传统思路 DFS
     *
     * @param matrix
     * @return
     */
    public int maximumMinimumPath2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        dfs(matrix, rows, cols, Integer.MAX_VALUE, 0, 0);

        return maxMin;
    }

    private void dfs(int[][] matrix, int rows, int cols, int prev, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }

        currentMin = Math.min(prev, matrix[i][j]);
        if (i == rows - 1 && j == cols - 1) {
            maxMin = Math.max(currentMin, maxMin);
            //最后一个
            return;
        }

        dfs(matrix, rows, cols, matrix[i][j], i + 1, j);
        dfs(matrix, rows, cols, matrix[i][j], i, j + 1);

    }

}
