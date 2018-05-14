package index.leetcode_cn.字符串;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-14.
 */
public class 字符串中的第一个唯一字符 {

    @Test
    public void go() {
        String s = "loveleetcode";
        assert firstUniqChar(s) == 2;

    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }

        if (s.length() == 1) {
            return 0;
        }

        char[] arr = s.toCharArray();
        //不包含特殊字符，128够用
        int[] map = new int[128];

        for (int i = 0; i < arr.length; i++) {
            map[arr[i]] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (map[arr[i]] == 1) {
                return i;
            }
        }

        return -1;

    }
}
