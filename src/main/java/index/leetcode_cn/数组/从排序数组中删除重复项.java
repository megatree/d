package index.leetcode_cn.数组;

import index.basicAlgo.QuickSort;
import index.basicAlgo.Sorts;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-05-11.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 */
public class 从排序数组中删除重复项 {

    @Test
    public void go() {
        int[] arr = {1, 1, 2, 5, 5, 8, 10};

        assert removeDuplicates(arr) == 5;
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 不需要排序,遍历赋值
     * 剩余空位如何处理
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        //快排
//        QuickSort.quickSort(nums, 0, nums.length - 1);

        int lastIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[lastIndex]) {
                continue;
            }

            lastIndex++;
            nums[lastIndex] = nums[i];
        }

        return lastIndex + 1;
    }

}
