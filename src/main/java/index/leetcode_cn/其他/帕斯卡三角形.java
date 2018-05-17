package index.leetcode_cn.其他;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhe.bj on 2018-05-17.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/67/
 */
public class 帕斯卡三角形 {

    @Test
    public void go() {

    }

    /**
     * 1ms
     * 100%
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if (numRows <= 0) {
            return result;
        }
        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        result.add(temp);
        if (numRows == 1) {
            return result;
        }

        //numRows>=2  i 为上一行索引
        for (int i = 0; i < numRows - 1; i++) {
            temp = new LinkedList<>();
            temp.add(1);

            //循环上一行的长度-1次
            List<Integer> lastLines = result.get(i);
            for (int j = 1; j < lastLines.size(); j++) {
                temp.add(lastLines.get(j) + lastLines.get(j - 1));
            }

            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}
