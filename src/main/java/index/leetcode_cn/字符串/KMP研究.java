package index.leetcode_cn.字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-11-23.
 */
public class KMP研究 {

    @Test
    public void test() {
        String a = "abcdaba";
        int[] next = next(a);
        System.out.println(Arrays.toString(next));
    }

    /**
     * 构造模式串的最大匹配数表
     *
     * @param p
     * @return
     */
    int[] next(String p) {
        int[] next = new int[p.length()];
        //迭代过程中，模式串的前缀数组长度
        int len = 0;

        for (int i = 1; i < p.length(); i++) {
            while (len > 0 && p.charAt(len) != p.charAt(i)) {
                len = next[len - 1];
            }
            if (p.charAt(i) == p.charAt(len)) {
                len++;
            }
            next[i] = len;
        }
        return next;
    }

//    作者：逍遥行
//    链接：https://www.zhihu.com/question/21923021/answer/37475572
    //https://segmentfault.com/a/1190000008575379
    //https://segmentfault.com/a/1190000007066358
}
