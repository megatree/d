package index.leetcode_cn.字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-11-23.
 * <p>
 * //    作者：逍遥行
 * //    链接：https://www.zhihu.com/question/21923021/answer/37475572
 * //https://segmentfault.com/a/1190000008575379
 * //https://segmentfault.com/a/1190000007066358
 */
public class KMP研究 {

    @Test
    public void test() {
        String a = "abcdabc";
        int[] next = getNext(a);
        System.out.println(Arrays.toString(next));
    }

    @Test
    public void test2() {
        assert strStr("mississippi", "pi") == 9;
        assert strStr("mississippi", "issip") == 4;
    }

    @Test
    public void test3(){
        System.out.println(strStr("abcdab","ef"));
    }

    /**
     * 构造模式串的最大匹配数表
     *
     * @param ps
     * @return
     */
    public int[] getNext(String ps) {

        char[] p = ps.toCharArray();
        int[] next = new int[p.length];

        next[0] = -1;
        int j = 0;
        int k = -1;

        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {

                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;

    }

    /**
     * 返回匹配到的索引开始位置
     *
     * @param string  主串
     * @param pattern 模式串
     * @return
     */
    public int strStr(String string, String pattern) {
        if (string == null
                || pattern == null
                || pattern.length() > string.length()) {
            return -1;
        }

        if ( pattern.length() == 0){
            return 0;
        }

        //正常情况
        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < string.length() && j < pattern.length()) {

            //如果当前索引匹配上
            if (j >= 0 && j < pattern.length()
                    && string.charAt(i) == pattern.charAt(j)) {

                //j匹配到最后一个
                if (j == pattern.length() - 1) {
                    return i - j;
                }

                i++;
                j++;
                continue;
            }

            //索引未匹配，模式串移动下标
            if (j < 0) {
                //-1
                i++;
                j++;
                continue;
            }

            //j重新赋值后才允许进行判断
            j = next[j];
        }

        return -1;
    }

}
