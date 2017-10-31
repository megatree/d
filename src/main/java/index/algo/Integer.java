package index.algo;

/**
 * Created by wangzhe.bj on 2017/8/29.
 */
public class Integer {

    public static void main(String[] args) {
        System.out.println(parseInteger("123"));
    }

    public static java.lang.Integer parseInteger(String s) {
        if (s == null) {
            throw new NumberFormatException("null");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();

        if (len > 0) {
            //当长度大于0时，先判断首位符号
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                } else if (firstChar != '+') {
                    throw new NumberFormatException("");
                }

                if (len == 1) {
                    throw new NumberFormatException("");
                }
                i++;
            }

            int digit;

            //然后循环每一位，*10+当前位
            while (i<len) {

                digit = Character.digit(s.charAt(i++), 10);

                if (digit < 0) {
                    throw new NumberFormatException("");
                }

                result = result * 10 + digit;


            }
        } else {
            throw new NumberFormatException("");
        }

        System.out.println(negative);
        return !negative ? result : -result;

    }
}
