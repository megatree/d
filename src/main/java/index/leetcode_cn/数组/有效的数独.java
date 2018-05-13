package index.leetcode_cn.数组;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-13.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class 有效的数独 {

    @Test
    public void go() {
        char[][] sudoku = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        assert !isValidSudoku(sudoku);

    }

    /**
     * 传统方式
     * 更快的方式需要用 位运算，& | << 这些
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[] map = new int[10];

        //横向扫描
        for (int i = 0; i < 9; i++) {
            for (int i1 = 0; i1 < 9; i1++) {
                if (isRepeated(map, board[i][i1])) {
                    //重复
                    return false;
                }
            }
            //换行
            flushMap(map);
        }

        //纵向扫描
        for (int i = 0; i < 9; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                if (isRepeated(map, board[i2][i])) {
                    return false;
                }
            }
            flushMap(map);
        }

        //宫格扫描

        for (int x = 0; x <= 6; x += 3) {
            for (int y = 0; y <= 6; y += 3) {
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (isRepeated(map, board[i][j])) {
                            return false;
                        }
                    }
                }
                flushMap(map);
            }
        }
        return true;
    }

    public boolean isRepeated(int[] map, char src) {
        if (src == '.') {
            return false;
        }

        if (map[src - 48] == 0) {
            map[src - 48] = 1;
            return false;
        }

        return true;
    }

    public void flushMap(int[] map) {
        for (int i = 0; i < map.length; i++) {
            map[i] = 0;
        }
    }
}
