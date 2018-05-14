package index.leetcode_cn.字符串;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-14.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/37/
 */
public class 字符串转整数 {

    @Test
    public void go() {
        assert myAtoi("-  42") == 0;
        assert myAtoi("42") == 42;
        assert myAtoi("4193 with words") == 4193;
        assert myAtoi("words and 987") == 0;
        assert myAtoi("-91283472332") == -2147483648;
    }


    /**
     * 29ms 86.4%
     *
     * 连续的数字方有效
     * 当第一个非空字符不为 + - 数字 时，不能有效转换，返回0
     * 当数组超过32位有符号整数范围时，返回范围边界
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }

        char[] arr = str.toCharArray();
        int length = arr.length;
        int i = 0;

        char pn = 0;
        boolean findFirstNum = false;
        while (i < length) {
            if (Character.isWhitespace(arr[i])) {
                i++;
                continue;
            }

            //至此，得到第一个不为空白的字符
            //既不是数字，也不是+ -号
            if (!Character.isDigit(arr[i]) && arr[i] != '+' && arr[i] != '-') {
                return 0;
            }

            break;
        }

        while (i < length) {
            //获取 + 或 -
            if (!Character.isDigit(arr[i])) {

                //只有+ 或 -
                //为其赋值符号
                if (pn == 0) {
                    pn = arr[i];
                } else {
                    //连续的加减号，无法有效计算
                    return 0;
                }
                i++;

                continue;
            }

            //至此，i为第一个数字
            findFirstNum = true;
            break;
        }

        //扫遍字符串，未找到一个数字
        if (!findFirstNum) {
            return 0;
        }

        int pni = pn == '-' ? -1 : 1;
        long sum = 0L;
        while (i < length) {
            if (!Character.isDigit(arr[i])) {
                //当数字不连续时，中断
                break;
            }

            sum = sum * 10 + (arr[i] - '0');
            if (sum * pni > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sum * pni < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) sum * pni;
    }
}
