package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by wangzhe.bj on 2018-06-19.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/131/
 * <p>
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class 基本计算器II {

    @Test
    public void go() {
        assert calculate("3+2*2") == 7;
        assert calculate(" 3/2 ") == 1;
        assert calculate(" 3+5 / 2 ") == 5;
        assert calculate(" 1-1+1 ") == 1;
        assert calculate(" -1-1+1 ") == -1;
        assert calculate("1*2-3/4+5*6-7*8+9/10") == -24;
        assert calculate("1+2*5/3+6/4*2") == 6;
    }

    /**
     * 仅包含非负整数，+， - ，*，/ 四种运算符和空格
     * 中缀表达式
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Character> operator = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        boolean init = true;
        int comb = 1;
        int len = s.length();
        int temp = 0;
        boolean isHigher = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            //过滤空格
            if (Character.isWhitespace(c)) {
                continue;
            }

            if (init) {
                if (c == '-') {
                    comb = -1;
                }
                init = false;
            }

            //是运算符
            if (!Character.isDigit(c)) {

                if (comb < 0) {
                    temp = temp * comb;
                    comb = 1;
                }
                numbers.push(temp);
                temp = 0;

                //遇到下一个运算符时，检查上个是否同级
                //下一个比上一个同级(!isHigher 之前没有升高操作)或低级，则计算上一个。
                //下一个比上一个高级，则入栈，不计算
                if (operator.size() > 0) {
                    char pre = operator.peek();
                    if (level(pre) == level(c) || level(c) < level(pre)) {
                        if (isHigher && level(c) < level(pre)) {
                            isHigher = false;
                        }

                        if (isHigher) {
                            //单次
                            process(operator, numbers);
                        } else {
                            //循环
                            while (operator.size() > 0) {
                                process(operator, numbers);
                            }
                        }

                    } else if (level(c) > level(pre)) {
                        isHigher = true;
                        //next 比 pre 高级，入栈，直到遇到低级
                    }
                }
                operator.push(c);
                continue;
            }

            //是数字
            temp = temp * 10 + (c - '0');

        }
        numbers.push(temp);

        //处理加减法
        while (operator.size() > 0) {
            process(operator, numbers);
        }
        return numbers.pop();
    }

    public void process(Stack<Character> operator, Stack<Integer> numbers) {
        int num2 = numbers.pop();
        int num1 = numbers.pop();
        int result = 0;

        char c = operator.pop();
        if (c == '*') {
            result = num1 * num2;
        } else if (c == '/') {
            result = num1 / num2;
        } else if (c == '+') {
            result = num1 + num2;
        } else {
            result = num1 - num2;
        }

        numbers.push(result);
    }

    public int level(char c) {
        if (c == '+' || c == '-') {
            return 1;
        }
        return 2;
    }
}
