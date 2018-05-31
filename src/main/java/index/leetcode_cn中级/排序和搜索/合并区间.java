package index.leetcode_cn中级.排序和搜索;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by wangzhe.bj on 2018-05-31.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/101/
 */
public class 合并区间 {

    private List<Interval> intervals = new ArrayList<>();

    @Before
    public void init() {
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
    }

    @Test
    public void go() {
        System.out.println(merge(intervals));
    }

    /**
     * 22ms 83.13%
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int lastStart = 0;
        int lastEnd = 0;
        Interval lastInterval = null;
        for (Interval interval : intervals) {
            //初始化
            if (lastInterval == null) {
                lastInterval = interval;
                lastStart = lastInterval.start;
                lastEnd = lastInterval.end;
                continue;
            }

            if (lastEnd >= interval.start && lastEnd<interval.end) {
                lastEnd = interval.end;
                continue;
            }

            if (lastEnd < interval.start) {
                result.add(new Interval(lastStart,lastEnd));
                lastStart = interval.start;
                lastEnd = interval.end;
                continue;
            }
        }

        result.add(new Interval(lastStart,lastEnd));
        return result;
    }
}
