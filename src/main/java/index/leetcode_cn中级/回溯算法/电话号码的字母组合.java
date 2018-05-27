package index.leetcode_cn中级.回溯算法;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhe.bj on 2018-05-26.
 * <p>
 * dfs 多叉树 深度优先搜索
 * <p>
 * 很多情况下，需要用全局变量
 */
public class 电话号码的字母组合 {

    public String[] chars   = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public int[]    lengths = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
    /**
     * 最终返回结果
     */
    List<String> result = new LinkedList<>();
    /**
     * 有效数字数组
     */
    int[]        numbers;
    /**
     * 有效数字总数（排除0 1）
     */
    private int    numberSize = 0;
    /**
     * 单个拼成的字符串结果
     */
    private char[] word;

    @Test
    public void go() {
        String arr = "234";
        System.out.println(letterCombinations(arr));

    }

    /**
     * 2ms
     *
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }

        numbers = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            //过滤0、1数字
            if (digits.charAt(i) == '0' || digits.charAt(i) == '1') {
                continue;
            }

            int digit = digits.charAt(i) - '0';
            numbers[numberSize] = digit;
            numberSize++;
        }

        if (numberSize == 0) {
            return result;
        }

        //当前多叉树层级
        int level = 0;
        word = new char[numberSize];
        dfs(0);

        return result;
    }

    /**
     * 动态叠加for循环
     *
     * @param level
     */
    public void dfs(int level) {
        //填到最后一层，完成一个字符串的遍历
        if (level >= numberSize) {
            result.add(new String(word));
            return;
        }

        //当前层级对应数字
        int num = numbers[level];
        //当前数字对应字符串
        String str = chars[num];

        //遍历当前字符串每个字符
        for (int i = 0; i < lengths[num]; i++) {
            word[level] = str.charAt(i);
            dfs(level + 1);
        }

    }

}
