package index.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzhe.bj on 2019-02-19.
 * <p>
 * Medium
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
 * (positions with parentheses in above matrix).
 * <p>
 * 链接：https://www.jianshu.com/p/1697aea331c1
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
public class Pacific_Atlantic_Water_Flow {

    int[][] grid = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
    };

    @Test
    public void main() {
        List<int[]> list = pacificAtlantic(grid);

        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 要求连通性问题，同时能流到两组边的点，因此从两组边出发，求能连通的点。设置两个矩阵，最后求重合
     *
     * @param matrix
     * @return
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int rows = matrix.length;
        if (rows <= 0) {
            return result;
        }
        int cols = matrix[0].length;

        boolean[][] pacificGrid = new boolean[rows][cols];
        boolean[][] atlanticGrid = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            // 两条竖边
            dfs(matrix, rows, cols, pacificGrid, Integer.MIN_VALUE, i, 0);
            dfs(matrix, rows, cols, atlanticGrid, Integer.MIN_VALUE, i, cols - 1);
        }

        for (int i = 0; i < cols; i++) {
            //两条横边
            dfs(matrix, rows, cols, pacificGrid, Integer.MIN_VALUE, 0, i);
            dfs(matrix, rows, cols, atlanticGrid, Integer.MIN_VALUE, rows - 1, i);
        }



        //计算重合点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificGrid[i][j] && atlanticGrid[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }


        return result;
    }

    private void dfs(int[][] matrix, int rows, int cols, boolean[][] visitedGrid, int pre, int i, int j) {
        //越界 访问过 小于pre ，条件结束
        if (i < 0 || i >= rows || j < 0 || j >= cols || visitedGrid[i][j] || matrix[i][j] < pre) {
            return;
        }
        //表明访问过
        visitedGrid[i][j] = true;
        //四个方向
        dfs(matrix, rows, cols, visitedGrid, matrix[i][j], i, j + 1);
        dfs(matrix, rows, cols, visitedGrid, matrix[i][j], i, j - 1);
        dfs(matrix, rows, cols, visitedGrid, matrix[i][j], i + 1, j);
        dfs(matrix, rows, cols, visitedGrid, matrix[i][j], i - 1, j);

    }
}
