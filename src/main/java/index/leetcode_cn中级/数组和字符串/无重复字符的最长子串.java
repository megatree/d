package index.leetcode_cn中级.数组和字符串;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-22.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/78/
 * <p>
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class 无重复字符的最长子串 {

    @Test
    public void go() {
        String a = "abcabcbb";
        assert lengthOfLongestSubstring(a) == 3;
        assert lengthOfLongestSubstring("bbbbb") == 1;
        assert lengthOfLongestSubstring("pwwkew") == 3;

    }

    /**
     * 题目所求为长度，因此可以不记录具体子串
     * 如果需要，仅需记录起止索引即可
     * 35ms 93.17%
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        if (len < 2) {
            return 1;
        }

        int max = 0;
        int tempMax = 0;
        int startIndex = 0;

        int index = startIndex;
        int[] map = new int[128];
        int version = 1;

        while (index < len) {
            //字符已经存在了，从上次未重复字符后一位开始重新计数，
            //版本+1
            if (exists(map, s.charAt(index), version)) {
                version++;

                startIndex++;
                index = startIndex;
                //下次循环才从本位开始算，置为0
                tempMax = 0;
            } else {
                //当前字符在当前子串中不存在，未重复
                index++;
                tempMax++;
            }

            //赋值最大长度
            if (tempMax > max) {
                max = tempMax;
            }

        }

        return max;
    }

    /**
     * 判断字符是否出现，并设置上版本号
     *
     * @param map
     * @param c
     * @param version
     * @return
     */
    public boolean exists(int[] map, char c, int version) {
        boolean flag = map[c] >= version;
        map[c] = version;
        return flag;
    }


}
