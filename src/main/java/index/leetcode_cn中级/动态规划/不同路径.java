package index.leetcode_cn中级.动态规划;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-31.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/105/
 */
public class 不同路径 {

    private int row   = 0;
    private int col   = 0;
    private int count = 0;

    @Test
    public void go() {
        int r = uniquePaths(23, 12);
        System.out.println(r);
    }


    /**
     * 超时
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_1(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        col = m;
        row = n;
        int len = row + col - 2;
        dfs(0, 0, 0, len);
        return count;
    }

    public void dfs(int level, int r, int c, int len) {
        if (level > len) {
            return;
        }

        if (r == row - 1 && c == col - 1) {
            count++;
            return;
        }

        if (!(r < row && c < col)) {
            return;
        }
        dfs(level + 1, r + 1, c, len);
        dfs(level + 1, r, c + 1, len);
    }

    /**
     * 1ms
     * 76%
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] p = new int[n][m];
        for (int i = 0; i < p.length; i++) {
            p[i][0] = 1;
        }
        for (int i = 0; i < p[0].length; i++) {
            p[0][i] = 1;
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                p[r][c] = p[r - 1][c] + p[r][c - 1];
            }
        }

        return p[n - 1][m - 1];
    }
}
