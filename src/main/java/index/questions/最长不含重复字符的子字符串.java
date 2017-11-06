package index.questions;

/**
 * Created by wangzhe.bj on 2017/11/6.
 */
public class 最长不含重复字符的子字符串 {

    public static void main(String[] args) {


    }


    public static String findLongestString(String s) {
        int[] position = new int[26];


        return null;
    }

    public static boolean validInput(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 'a' || chars[i] > 'z') {
                return false;
            }
        }
        return true;
    }
}
