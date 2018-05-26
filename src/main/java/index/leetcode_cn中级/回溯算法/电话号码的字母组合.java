package index.leetcode_cn中级.回溯算法;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhe.bj on 2018-05-26.
 */
public class 电话号码的字母组合 {

    public String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    @Test
    public void go() {

    }

    public List<String> letterCombinations(String digits) {

        List<String> list = new LinkedList<>();

        for (int i = 0; i < digits.length(); i++) {
            //过滤0、1数字
            if (digits.charAt(i) == '0' || digits.charAt(i) == '1') {
                continue;
            }

            int digit = digits.charAt(i) - '0';
            String str = chars[digit];
            list.add(str);
        }


    }
}
