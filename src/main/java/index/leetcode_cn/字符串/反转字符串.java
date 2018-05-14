package index.leetcode_cn.字符串;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-14.
 */
public class 反转字符串 {

    @Test
    public void go() {
        String s = "hello";

        System.out.println(reverseString(s));
    }

    /**
     * On O1
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        char[] arr = s.toCharArray();
        int h = 0;
        int t = arr.length - 1;

        while (h < t) {
            char temp = arr[h];
            arr[h] = arr[t];
            arr[t] = temp;

            h++;
            t--;
        }

        return new String(arr);
    }


}
