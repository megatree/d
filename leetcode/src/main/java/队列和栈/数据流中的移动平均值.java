package 队列和栈;

import org.junit.Test;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * <p>
 * 给一个整数流和一个窗口，计算在给定大小的窗口里的数字的平均值。
 * <p>
 * 解法：队列queue，用一个queue记录进入窗口的整数。当流进窗口的整数不足时，计算所有窗口内的数字和返回，当进入窗口的整数多于窗口大小时，移除最先进入窗口的整数，新的整数进入queue，然后计算窗口内的整数和。
 *
 * @Author: wangzhe
 * @Date: 2019-07-16
 */
public class 数据流中的移动平均值 {

    @Test
    public void test() {
        MovingAverage m = new MovingAverage(3);
        assert m.next(1) == 1;
        assert m.next(10) == 5;
        assert m.next(3) == 4;
        assert m.next(5) == 6;

    }

    public static class MovingAverage {

        int  headVal    = 0;
        int  windowSize = 0;
        int  count      = 0;
        long sum        = 0L;

        public MovingAverage(int size) {
            this.windowSize = size;
        }

        public double next(int val) {
            if (count == 0) {
                headVal = val;
            }

            if (count < windowSize) {
                count++;
                sum += val;
                return sum / count;
            }

            //窗口满了
            sum -= headVal;
            headVal = val;
            sum += val;
            return sum / count;

        }
    }
}
