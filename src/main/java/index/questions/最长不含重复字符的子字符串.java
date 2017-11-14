package index.questions;

/**
 * Created by wangzhe.bj on 2017/11/6.
 */
public class 最长不含重复字符的子字符串 {

    public static void main(String[] args) {

        String s = "123456712345";
        System.out.println(findLongestString(s));

    }


    public static String findLongestString(String s) {

        int[] position = new int[128];
        char[] arr = s.toCharArray();

        /** 历史存储最长字符串起止索引 */
        int storeIx0 = 0;
        int storeIx1 = 0;
        /** 当前遍历的字符串起止索引 */
        int curIx0 = 0;
        int curIx1 = 0;

        /** position数组版本号，
         * 每更换一次最长起止字符串，版本号+1 */
        int version = 1;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            //更新当前末端索引
            curIx1 = i;

            //当前字符重复，重新指定当前前端索引
            if (position[c] == version) {
                curIx0 = i;
                version++;
            }

            //当前字符串比历史字符串长时，替换
            if ((curIx1 - curIx0) > (storeIx1 - storeIx0)) {
                storeIx0 = curIx0;
                storeIx1 = curIx1;
            }

            //最后在position中将此字符版本号+1
            position[c] += 1;
        }


        return s.substring(storeIx0, storeIx1 + 1);
    }

    @Deprecated
    public static boolean validInput(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 'a' || chars[i] > 'z') {
                return false;
            }
        }
        return true;
    }
}
