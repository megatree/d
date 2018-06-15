package index.leetcode_cn高级.数组和字符串;

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

    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        row = board.length;
        col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                changeState(r, c);
            }
        }

    }

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

        if (sum==2){

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
