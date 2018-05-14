package index.leetcode_cn.字符串;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-14.
 */
public class 颠倒整数 {

    @Test
    public void go() {
        int x = -2147483412;
        System.out.println(reverse(x));
    }

    /**
     * 可以用long
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long result = 0L;

        char[] arr = String.valueOf(x).toCharArray();
        int len = arr.length;
        int tail = len - 1;

        while (true) {
//            int single = x % 10;
//            x = x / 10;

            if (tail < 0) {
                break;
            }

            if (arr[tail] == '-') {
                result *= -1;
                break;
            }

            char end = arr[tail];
            tail--;
            int single = end - '0';

            result = result * 10 + single;
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return 0;
            }

//            if (x == 0) {
//                break;
//            }
        }
        return (int) result;
    }

    /**
     * 传统方法
     *
     * @param x
     * @return
     */
    public int reverse_1(int x) {
        if (x > -10 && x < 10) {
            return x;
        }

        boolean isNegative = x < 0;

        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        int h = 0;
        int t = arr.length - 1;
        //找到左面第一个不为负号的坐标
        //找到右面第一个不为0的坐标
        while (h < t) {
            if (arr[h] == '-') {
                h++;
                continue;
            }

            if (arr[t] == '0') {
                t--;
                continue;
            }

            break;
        }

        //待翻转有效数字长度
        int len = t - h + 1;
        char[] temp = new char[len];
        for (int i = t, j = 0; i >= h; i--) {
            temp[j] = arr[i];
            j++;
        }

        char[] min = String.valueOf(Integer.MIN_VALUE).toCharArray();
        char[] max = String.valueOf(Integer.MAX_VALUE).toCharArray();

        if (isOverFlow(min, max, temp, isNegative)) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            int k = temp[i] - '0';
            sum = sum * 10 + k;
        }

        return (isNegative ? -1 : 1) * sum;
    }

    public boolean isOverFlow(char[] min, char[] max, char[] arr, boolean isNegative) {

        //负数
        if (isNegative) {
            if (arr.length + 1 < min.length) {
                //没有溢出
                return false;
            }

            if (arr.length + 1 == min.length) {
                for (int i = 1; i < min.length; i++) {
                    if (min[i] < arr[i - 1]) {
                        //溢出
                        return true;
                    }

                    if (min[i] > arr[i - 1]) {
                        //高位比较大，不会溢出
                        return false;
                    }
                }

                //每一位均相等
                return false;
            }
            return true;
        } else {
            //正数
            if (arr.length < max.length) {
                //没有溢出
                return false;
            }

            if (arr.length == max.length) {
                for (int i = 0; i < max.length; i++) {
                    if (max[i] < arr[i]) {
                        //溢出
                        return true;
                    }

                    if (max[i] > arr[i]) {
                        //高位比较大，不会溢出
                        return false;
                    }
                }
                return false;
            }
            return true;

        }

    }
}
