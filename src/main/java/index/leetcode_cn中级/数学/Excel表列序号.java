package index.leetcode_cn中级.数学;

import org.junit.Test;

/**
 * Created by mythss on 2018-06-04.
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/114/
 *
 *
 *
 */
public class Excel表列序号 {

    @Test
    public void go() {

        assert titleToNumber("A") == 1;
        assert titleToNumber("AB") == 28;
        assert titleToNumber("ZY") == 701;

    }


    /**
     * 99.01%
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int sum = 0;
        //倒序扫描
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            sum = c - 64 + sum * 26;
        }
        return sum;
    }

}
