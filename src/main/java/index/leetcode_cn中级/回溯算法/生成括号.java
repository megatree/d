package index.leetcode_cn中级.回溯算法;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhe.bj on 2018-05-27.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/92/
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class 生成括号 {

    private int          limitSize  = 0;
    private int          unitLength = 0;
    private int          leftTotal  = 0;
    private int          left       = 0;
    private char[]       unit;
    private List<String> result     = new LinkedList<>();
    private char[]       enums      = {'(', ')'};

    @Test
    public void go() {
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return result;
        }

        limitSize = n;
        unitLength = 2 * n;
        unit = new char[unitLength];
        dfs(0);
        return result;
    }

    /**
     * @param level
     */
    public void dfs(int level) {
        if (level >= unitLength) {
            //所有位置装填完毕
            result.add(new String(unit));
            return;
        }


        for (int i = 0; i < enums.length; i++) {
            //放右括号
            if (leftTotal >= limitSize || level == unitLength - 1 || left >= limitSize) {
                unit[level] = enums[1];
                left--;
                dfs(level + 1);
                return;
            }

            //放左括号
            if (level == 0 || left <= 0) {
                unit[level] = enums[0];
                left++;
                leftTotal++;
                dfs(level + 1);
                return;
            }

            unit[level] = enums[i];
            if (i == 0) {
                left++;
                leftTotal++;
            } else {
                //右括号
                left--;
            }
            dfs(level + 1);
        }


    }
}
