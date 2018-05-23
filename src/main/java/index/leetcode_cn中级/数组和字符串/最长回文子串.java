package index.leetcode_cn中级.数组和字符串;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-22.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/79/
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class 最长回文子串 {

    @Test
    public void go() {

//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abb"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        //填充#，使其每一个子序列都为奇数，存在中点
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i)).append("#");
        }

        String arr = sb.toString();
        int arrLen = arr.length();
        String maxStr = "";
        int maxLen = 0;

        int index = 0;
        while (index < arrLen) {
            String temp = outwardScanning(arr, index, 1, arrLen - 1, maxLen);
            if (temp != null) {
                maxLen = temp.length();
                maxStr = temp;
            }

            //在这里优化，向右遍历，滤掉无效循环
            index++;
        }

        return maxStr;
    }

    /**
     * 由中心向外层扫描，返回去除#的字符串
     *
     * @param src
     * @param midIndex
     * @param leftBorder
     * @param rightBorder
     * @return
     */
    public String outwardScanning(String src, int midIndex, int leftBorder, int rightBorder, int maxLen) {

        int left = midIndex - 1;
        int right = midIndex + 1;
        int curPalinLength = src.charAt(midIndex) == '#' ? 0 : 1;


        while (left >= leftBorder && right <= rightBorder) {
            //此时结束回文
            if (src.charAt(left) != src.charAt(right)) {
                left++;
                right--;
                break;
            }

            //此处left right 相等
            if (src.charAt(left) != '#') {
                curPalinLength += 2;
            }

            left--;
            right++;
        }

        //当前回文长度确定，与最大回文长度比较
        if (curPalinLength > maxLen) {
            StringBuilder sb = new StringBuilder();

            //将left right 回退到合法位置
            while (!(left >= leftBorder && right <= rightBorder)) {
                left++;
                right--;
            }

            for (int i = left; i <= right; i++) {
                if (src.charAt(i) != '#') {
                    sb.append(src.charAt(i));
                }
            }
            return sb.toString();
        }

        return null;
    }

}
