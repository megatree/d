package index.leetcode_cn中级.排序和搜索;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-31.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/103/
 */
public class 搜索2D矩阵II {

    @Test
    public void go() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        assert searchMatrix(matrix, 5);
        assert !searchMatrix(matrix, 20);
        assert !searchMatrix(matrix, 0);
        assert !searchMatrix(matrix, 50);
        assert searchMatrix(matrix, 22);
    }

    /**
     * 应该从右上向左下找
     * 这样向下可以增加，向左可以减少
     *
     * 11ms 95.18%
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        int r = 0;
        int c = col - 1;

        while (0 <= r && r < row && 0 <= c && c < col) {

            if (matrix[r][c] == target) {
                return true;
            }

            if (matrix[r][c] > target) {
                c--;
                continue;
            }

            if (matrix[r][c] < target) {
                r++;
                continue;
            }
        }
        return false;
    }
}
