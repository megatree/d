package index.leetcode_cn.字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-05-14.
 */
public class 有效的字母异位词 {

    @Test
    public void go() {
        String s = "anagram";
        String t = "nagaram";
        assert isAnagram(s,t);

        assert !isAnagram("rat","cat");

    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        Arrays.sort(cs);
        Arrays.sort(ct);

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ct[i]) {
                return false;
            }
        }

        return true;
    }
}
