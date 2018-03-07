package index.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * Created by wangzhe.bj on 2017/11/27.
 */
public class 打印字符串的所有排列 {

    public static void main(String[] args) {
        String str = "abc";
//        permutation(str.toCharArray(), 0);

        ArrayList list = Permutation2(str);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 递归全排列
     * @param str
     * @param i
     */
    public static void permutation(char[] str, int i) {
        if (i >= str.length) {
            return;
        }
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                permutation(str, i + 1);

                //字符恢复原状
                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }


    /**
     * 递归方式全排列2
     * @param str
     * @return
     */
    public static ArrayList Permutation2(String str) {
        ArrayList res = new ArrayList();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }


    public static void PermutationHelper(char[] cs, int i, ArrayList list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < cs.length; ++j) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }
}
