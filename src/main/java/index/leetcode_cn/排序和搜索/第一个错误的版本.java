package index.leetcode_cn.排序和搜索;

import org.junit.Test;

import java.util.Random;

/**
 * Created by wangzhe.bj on 2018-05-16.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/53/
 */
public class 第一个错误的版本 {

    @Test
    public void go() {


    }

    /**
     * 二分搜索
     * 15 ms 94.25%
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        if (n < 2) {
            return isBadVersion(n) ? n : 0;
        }

        int start = 1;
        int end = n;

        while (start < end) {
            //这种写法保证int 不会溢出
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                // 包含mid，要使结果覆盖全
                end = mid;
            } else {
                start = mid + 1;
            }

        }

        //此时start==end
        return start;

    }


    boolean isBadVersion(int version) {

//        2126753390 versions
//        1702766719 is the first bad version.
        if (version >= 1702766719) {
            return true;
        }
        return false;
    }
}
