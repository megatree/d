package index.leetcode_cn.字符串;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-14.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/
 * <p>
 * 类似indexOf
 * 当needle为空时，返回0
 * 找不到时返回-1
 */
public class 实现strStr {

    @Test
    public void go() {

//        assert strStr("hello", "ll") == 2;
//        assert strStr("aaaaa", "bba") == -1;

        assert strStr("mississippi", "pi") == 9;
        assert strStr("mississippi", "issip") == 4;

    }


    /**
     * 可以用KMP优化
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        //此处开始在haystack中搜索needle
        int ih = 0;
        int in = 0;
        int lastMatchIndex = -1;

        char[] ch = haystack.toCharArray();
        char[] cn = needle.toCharArray();

        while (ih < ch.length && in < cn.length) {
            if (cn[in] != ch[ih]) {
                ih++;
                continue;
            }

            //第一个字母相等
            //简单判断一下，后面数组长度是否够
            //needle 后面字符长度超过haystack剩余字符长度，无效
            if (cn.length - in > ch.length - ih) {
                return -1;
            }

            if (in == cn.length - 1 && cn[in] == ch[ih]) {
                //返回最初相等位置
                return ih - cn.length + 1;
            }

            //两个对应字符相等
            //只在needle第一个字母匹配时赋值
            if (in == 0) {
                lastMatchIndex = ih;
            }

            ih++;
            in++;

            //向后移动后，再次判断，如果不等则needle指针归0
            if (cn[in] != ch[ih]) {
                in = 0;
                ih = lastMatchIndex + 1;
            }

        }

        return -1;
    }
}
