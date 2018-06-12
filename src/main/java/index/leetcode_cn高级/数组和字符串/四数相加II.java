package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhe.bj on 2018-06-06.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/125/
 */
public class 四数相加II {

    @Test
    public void go() {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        assert 2 == fourSumCount(A, B, C, D);
    }

    /**
     * 前两个数组合并，将遍历求和结果放入map。并在后两个数组中寻找其相反数
     * 129ms 93.49%
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length==0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                //每个组合计数
                map.put(A[i] + B[i1], map.getOrDefault(A[i] + B[i1], 0) + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int i1 = 0; i1 < D.length; i1++) {
                count += map.getOrDefault(-C[i] - D[i1], 0);
            }
        }

        return count;
    }
}
