package index.leetcode_cn.字符串;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-14.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
 */
public class 数数并说 {

    @Test
    public void go() {

        assert countAndSay(1).equals("1");
        assert countAndSay(4).equals("1211");

    }

    /**
     * 3ms
     * 99.53%
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        if (n==1){
            return "1";
        }

        String src = "1";
        for (int i = 0; i < n-1; i++) {
            src = count(src);
        }

        return src;
    }

    public String count(String src) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int length = src.length();

        char lastChar = '.';
        int times = 1;
        while (i < length) {

            //循环到下一个数时，才把前面数字入队
            if (src.charAt(i) != lastChar) {
                //拼接新数
                if (lastChar != '.') {
                    sb.append(times).append(lastChar);
                }

                lastChar = src.charAt(i);
                //连续次数清零
                times = 1;

            } else {
                //和lastChar 相等
                times++;
            }

            i++;
        }
        if (lastChar != '.') {
            sb.append(times).append(lastChar);
        }

        return sb.toString();
    }
}
