package index.leetcode_cn中级.回溯算法;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-28.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/95/
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class 单词搜索 {

    private int     row       = 0;
    private int     col       = 0;
    private int     len       = 0;
    private boolean isMatched = false;

    @Test
    public void go() {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        assert exist(board, "ABCCED");
        assert exist(board, "SEE");
        assert !exist(board, "ABCB");

    }

    /**
     * 15ms 70.23%
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        isMatched = false;

        if (word == null || word.length() == 0) {
            return true;
        }

        len = word.length();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        row = board.length;
        col = board[0].length;

        /** 判空检查结束 */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, word, 0);
                if (isMatched) {
                    return true;
                }
            }

        }
        return false;

    }

    private void dfs(char[][] board, int i, int j, String word, int level) {
        //如果找到一组，立刻返回
        if (isMatched){
            return;
        }

        if (level == len) {
            //说明之前匹配
            isMatched = true;
            return;
        }

        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }


        //刚匹配一半
        if (word.charAt(level) != board[i][j]) {
            //这个方向匹配不上
            return;
        }

        //匹配上了
        char temp = board[i][j];
        //防止重复
        board[i][j] = '0';

        dfs(board, i, j + 1, word, level + 1);
        dfs(board, i + 1, j, word, level + 1);
        dfs(board, i - 1, j, word, level + 1);
        dfs(board, i, j - 1, word, level + 1);

        //恢复
        board[i][j] = temp;
    }
}
