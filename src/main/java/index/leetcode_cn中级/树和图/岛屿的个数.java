package index.leetcode_cn中级.树和图;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-26.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/90/
 * <p>
 * 图
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */
public class 岛屿的个数 {

    @Test
    public void go() {

    }

    /**
     * 每当遇到一个1，将其相邻方向上的1置为0，最后扫描有几个1
     *
     * 6ms
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        //岛屿数量
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsSearch(grid, i, j, row, col);
                }
            }
        }


        return count;
    }

    /**
     * 深度优先搜索，将当前元素周围相邻元素均置为0
     *
     * @param grid
     * @param i
     * @param j
     * @param row
     * @param col
     */
    public void dfsSearch(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        //当前置零
        grid[i][j] = '0';
        //四个方向相邻元素遍历
        dfsSearch(grid, i - 1, j, row, col);
        dfsSearch(grid, i + 1, j, row, col);
        dfsSearch(grid, i, j - 1, row, col);
        dfsSearch(grid, i, j + 1, row, col);

    }
}
