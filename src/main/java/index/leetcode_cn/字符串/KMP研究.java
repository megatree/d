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

}
