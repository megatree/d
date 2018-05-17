package index.leetcode_cn.数学;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/63/
 */
public class 罗马数字转整数 {

    //写错了
//    private String[] units     = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//    private String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//    private String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//    private String[] thousands = {"", "M", "MM", "MMM", "", "", "", "", "", ""};

    private int[] map = new int[27];

    {
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
    }

    @Test
    public void go() {
        assert romanToInt("III") == 3;
        assert romanToInt("IV") == 4;
        assert romanToInt("IX") == 9;
        assert romanToInt("LVIII") == 58;
        assert romanToInt("MCMXCIV") == 1994;
    }

    /**
     * 60 ms ms 90.08%
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int length = s.length();
        if (length == 1) {
            return number(s.charAt(0));
        }

        //长度>=2
        int index = 0;
        int sum = 0;
        //剩余最后一位
        while (index < length - 1) {
            char cur = s.charAt(index);
            //系列1
            if (isSeries1(cur)) {
                //同级1 后面连续为1
                while (index < length - 1 && s.charAt(index + 1) == cur) {
                    sum += number(cur);
                    index++;
                }

                if (index + 1 >= length) {
                    continue;
                }

                //同级5 或者 高级1
                if (isSameSeries(cur, s.charAt(index + 1)) ||
                        isHigherSeries1(cur, s.charAt(index + 1))) {
                    index++;
                    sum = sum - number(cur) + number(s.charAt(index));
                    index++;
                    continue;
                }

                //高级 5 不存在
                //低级1 5
                sum += number(cur);
                index++;
                continue;
            }

            //5系列
            if (isSeries5(cur)) {
                sum += number(cur);
                index++;
                //最多连续3个
                continue;
            }
        }

        if (index < length) {
            sum += number(s.charAt(index));
        }
        return sum;

    }

    public int number(char romeNum) {
        return map[romeNum - 'A'];
    }

    /**
     * 1系列
     *
     * @param c
     * @return
     */
    public boolean isSeries1(char c) {
        int n = number(c);
        return n == 1 || n == 10 || n == 100 || n == 1000;
    }

    /**
     * 5系列
     *
     * @param c
     * @return
     */
    public boolean isSeries5(char c) {
        int n = number(c);
        return n == 5 || n == 50 || n == 500;
    }

    public boolean isHigherSeries1(char src, char dst) {
        return number(dst) / 10 == number(src);
    }

    public boolean isSameSeries(char serie1, char seire5) {
        return number(serie1) * 5 == number(seire5);
    }
}
