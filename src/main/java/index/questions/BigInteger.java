package index.questions;

/**
 * Created by wangzhe.bj on 2017/11/4.
 */
public class BigInteger {

    public static void main(String[] args) {
        String s1 = "1111111";
        String s2 = "222";
        add(s1, s2);

    }

    public static String add(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        int maxLen = Math.max(len1, len2);
        int[] mids = new int[maxLen];
        for (int i = maxLen - 1; i >= 0; i--) {
            int ix = maxLen - i - 1;

            if (ix < len1) {

            }
        }


        return null;
    }


}
