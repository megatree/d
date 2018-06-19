package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-06-19.
 */
public class 滑动窗口最大值 {

    int max      = Integer.MIN_VALUE;
    int maxCount = 0;

    @Test
    public void go() {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] re = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(re));
    }

    @Test
    public void go2() {
        int[] arr = {1, -1};
        int[] re = maxSlidingWindow(arr, 1);
        System.out.println(Arrays.toString(re));
    }

    /**
     * 5ms
     * 90.44%
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }

        int rlen = nums.length - k + 1;
        int[] result = new int[rlen];

        findMax(nums, 0, k - 1);
        result[0] = max;

        for (int i = 1; i <= nums.length - k; i++) {
            int idxEnd = i + k - 1;
            int idxPre = i - 1;

            //新加的
            if (nums[idxEnd] > max) {
                max = nums[idxEnd];
                maxCount = 1;
            } else if (nums[idxEnd] == max) {
                //不重新对max赋值
                //维护maxCount状态
                if (nums[idxPre] < max) {
                    //最右侧为max，使得count+1
                    maxCount++;
                }
                //nums[idxPre]==max maxCount 不变
                //nums[idxPre]>max 不存在
            } else {
                //nums[idxEnd] < max，此时判断前一个滑出窗口数字与max关系
                if (nums[idxPre] == max) {
                    maxCount--;
                }

                if (maxCount == 0) {
                    //当前滑动窗口内不存在max，需重新初始化
                    findMax(nums, i, idxEnd);
                }
            }
            result[i] = max;
        }
        return result;
    }

    public void findMax(int[] nums, int start, int end) {
        max = Integer.MIN_VALUE;
        maxCount = 0;
        //初始化
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxCount = 1;
            } else if (nums[i] == max) {
                maxCount++;
            }
        }
    }

}
