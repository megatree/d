package index.leetcode_cn中级.数组和字符串;

import index.common.MatrixUtils;
import org.junit.Test;

/**
 * Created by mythss on 2018-05-21.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/76/
 */
public class 矩阵置零 {

    @Test
    public void go() {
        int[][] matrix = {
                {1},
                {3},
                {0}
        };

        setZeroes(matrix);

        MatrixUtils.print(matrix);

    }

    /**
     * 1ms
     * 100%
     *
     * O（m+n）用俩数组分别记录为零的行列
     * 其实可以在原数组记录，达到O1，比如用第一行记录列，再用一个bool记录第一行是否本来有0。如果本来有0，只需要在最后整行变0
     * 逐行扫描，根据第一行记录的列置零。
     * 如果第一行不为0，那么需要从本位置向上所有位置置零
     * 核心思想是将每一行的0投影到第一行，扫描每行时独立处理本行置零
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        if (rowLen == 0) {
            return;
        }

        //判断首行是否有0
        boolean firstRowHasZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        int colLen = matrix[0].length;
        if (rowLen > 1) {
            for (int i = 1; i < rowLen; i++) {
                boolean lineZero = false;
                for (int j = 0; j < colLen; j++) {
                    if (matrix[i][j] == 0) {
                        lineZero = true;
                        //如果此时首行不为0，那么从此位置起向上均置为0。
                        //后面行的0应当影响本行以上的0

                        if (matrix[0][j] != 0) {
                            for (int k = i; k >=0 ; k--) {
                                matrix[k][j] = 0;
                            }
                        }

                        //如果此位本身为0，不需要根据第一行再次置零
                        continue;
                    }

                    if (matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }

                //本行置零
                if (lineZero) {
                    for (int j = 0; j < colLen; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //首行置零
        if (firstRowHasZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
