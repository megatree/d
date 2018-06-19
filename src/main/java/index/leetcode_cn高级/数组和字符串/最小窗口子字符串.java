package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-06-19.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/133/
 * <p>
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class 最小窗口子字符串 {

    @Test
    public void go() {
        String min = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(min);
    }

    @Test
    public void go2() {
        String min = minWindow("ADOBECODEBANC", "BDDS");
        System.out.println(min);
    }

    @Test
    public void go3() {
        String min = minWindow("bba", "ab");
        System.out.println(min);
    }

    public String minWindow_(String s, String t) {
        if ("".equals(s) || "".equals(t)) {
            return "";
        }

        int tlen = t.length();
        int slen = s.length();

        if (slen < tlen) {
            return "";
        }


        int[] map = new int[128];
        final int[] finalMap = new int[128];

        //重置map
        refresh(map, t);
        initCount(finalMap, t);

        //当前指针
        int cur = 0;
        int last = cur;
        //第二个命中索引
        int index2 = 0;
        //字符串
        StringBuilder sb = new StringBuilder();
        int charLeft = tlen;
        String minStr = null;
        boolean hit = false;

        while (cur < slen) {
            char c = s.charAt(cur);
            if (hit) {
                sb.append(c);
            }

            if (map[c] == 0) {
                cur++;
                continue;
            }

            if (map[c] <= finalMap[c]) {
                charLeft--;
                if (charLeft == tlen - 1 && !hit) {
                    hit = true;
                    sb.append(c);
                }
            }
            map[c] += 1;


            if (charLeft == tlen - 2) {
                //标记第二个索引位置
                index2 = cur;
            }

            if (charLeft == 0) {
                //完成一个
                if (minStr == null || minStr.length() > sb.toString().length()) {
                    minStr = sb.toString();
                }
                //重设
                sb.setLength(0);
                if (index2 > 0) {
                    cur = index2;
                } else {
                    cur++;
                }

                charLeft = tlen;
                refresh(map, t);
                continue;
            }

            cur++;
        }

        return minStr == null ? "" : minStr;
    }

    public void refresh(int[] map, String t) {
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)] = 1;
        }
    }

    public void initCount(int[] map, String t) {
        for (int i = 0; i < t.length(); i++) {
            int v = map[t.charAt(i)];
            map[t.charAt(i)] = v + 1;
        }
    }

    @Test
    public void go4(){
        minWindow("abcabc","bc");
    }

    public String minWindow(String src, String target) {
        if ("".equals(src) || "".equals(target)) {
            return "";
        }

        int tlen = target.length();
        int slen = src.length();

        if (slen < tlen) {
            return "";
        }

        int[] targetMap = new int[128];
        int[] srcMap = new int[128];

        for (int i = 0; i < tlen; i++) {
            targetMap[target.charAt(i)]++;
        }

        //从左向右滑动窗口
        int start = 0;
        int end = 0;
        for (end = 0; end < slen; end++) {
            //右边界先向右扩展，找齐所有数字
            //然后左边界向右移动，缩小滑动窗口

//            aHR0cHM6Ly9zZWdtZW50ZmF1bHQuY29tL2EvMTE5MDAwMDAwMzcwNzMxMw==
        }


        return null;
    }

}