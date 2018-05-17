package index.leetcode_cn.其他;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-17.
 */
public class 有效的括号 {

    @Test
    public void go() {

    }

    /**
     * 7 ms
     * 95.38%
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len = s.length();
        char[] arr = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            //跳过空格
            if (Character.isWhitespace(s.charAt(i))) {
                continue;
            }

            //如果是右括号
            if (!isLeftBracket(s.charAt(i))) {
                //如果此时index==0 即还没有左括号放入arr
                if (index == 0) {
                    return false;
                }

                //遇到的右括号与左括号不匹配
                if (arr[--index] != leftBracket(s.charAt(i))) {
                    return false;
                }

            } else {
                //是左括号，放入arr
                arr[index] = s.charAt(i);
                index++;
            }

        }
        return index == 0;
    }

    public boolean isLeftBracket(char c) {
        if (c == '(' || c == '{' || c == '[') {
            return true;
        }
        return false;
    }

    /**
     * 返回右括号对应的左括号
     *
     * @param right
     * @return
     */
    public char leftBracket(char right) {
        if (right == ')') {
            return '(';
        }

        if (right == '}') {
            return '{';
        }

        return '[';
    }


}
