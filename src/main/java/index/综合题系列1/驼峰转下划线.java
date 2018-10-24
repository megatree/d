package index.综合题系列1;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-10-24.
 */
public class 驼峰转下划线 {

    @Test
    public void test() {
        String a = "bigCase";
        String b = "A";
        String c = "a";
        String d = "abcFuck123";

        System.out.println(camel2underline(a));
        System.out.println(camel2underline(b));
        System.out.println(camel2underline(c));
        System.out.println(camel2underline(d));
    }

    /**
     * 特殊情况
     * 比如UserID转了应该是user_ID
     *
     * @param var
     * @return
     */
    public String camel2underline(String var) {
        if (var == null || var.length() == 0) {
            return var;
        }
        int len = var.length();
        StringBuilder sb = new StringBuilder();

        //首位字母如果大写，转小写
        char firstC = var.charAt(0);
        if (isUpperCase(firstC)) {
            sb.append(upper2lower(firstC));
        } else {
            sb.append(firstC);
        }

        if (len < 2) {
            return sb.toString();
        }

        //大写转下划线小写
        for (int i = 1; i < len; i++) {
            char c = var.charAt(i);
            if (isUpperCase(c)) {
                sb.append("_").append(upper2lower(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public boolean isUpperCase(char c) {
        return c >= 65 && c <= 90;
    }

    public char upper2lower(char c) {
        return (char) (c + 32);
    }


}
