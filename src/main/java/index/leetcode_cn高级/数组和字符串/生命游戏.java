package index.leetcode_cn高级.数组和字符串;

import index.common.MatrixUtils;
import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-06-15.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/127/
 */
public class 生命游戏 {

    public int row = 0;
    public int col = 0;

    @Test
    public void go() {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        gameOfLife(board);

        MatrixUtils.print(board);
    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        row = board.length;
        col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                changeState(board, r, c);
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int t = board[r][c];
                if (t == 2) {
                    board[r][c] = 1;
                } else if (t == 3) {
                    board[r][c] = 0;
                }
            }
        }

    }

    /**
     * 0、1、2（0->1）、3（1->0）
     *
     * @param board
     * @param r
     * @param c
     */
    public void changeState(int[][] board, int r, int c) {
        int sum = 0;
        sum += checkState(board, r - 1, c - 1);
        sum += checkState(board, r - 1, c);
        sum += checkState(board, r - 1, c + 1);
        sum += checkState(board, r, c + 1);
        sum += checkState(board, r + 1, c + 1);
        sum += checkState(board, r + 1, c);
        sum += checkState(board, r + 1, c - 1);
        sum += checkState(board, r, c - 1);

        //维持现状 if (sum == 2)
        if (sum == 3) {
            //强制存活
            if (board[r][c] == 0) {
                board[r][c] = 2;
            }
        } else if (sum != 2) {
            //强制死亡
            if (board[r][c] == 1) {
                board[r][c] = 3;
            }
        }
    }

    public int checkState(int[][] board, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return 0;
        }

        if (board[r][c] == 1 || board[r][c] == 3) {
            return 1;
        }

        return 0;
    }
}
