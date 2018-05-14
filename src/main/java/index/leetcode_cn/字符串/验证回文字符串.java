package index.leetcode_cn.字符串;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-14.
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/
 *
 * 说明，
 * 如果字符串没有字母和数字，则算空字符串
 */
public class 验证回文字符串 {

    @Test
    public void go() {
        assert isPalindrome("A man, a plan, a canal: Panama");
        assert !isPalindrome("race a car");
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] arr = s.toCharArray();

        int h = 0;
        int t = arr.length - 1;
        while (h < t) {
            if (!isValid(arr[h])) {
                h++;
                continue;
            }

            if (!isValid(arr[t])) {
                t--;
                continue;
            }

            if (Character.toLowerCase(arr[h]) != Character.toLowerCase(arr[t])) {
                return false;
            }

            h++;
            t--;
        }
        return true;
    }

    public boolean isValid(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }


        if (c >= 'a' && c <= 'z') {
            return true;
        }

        if (c >= 'A' && c <= 'Z') {
            return true;
        }

        return false;
    }
}
