package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-06-05.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/123/
 */
public class 除自身之外其余各元素的乘积 {

    @Test
    public void go() {
        int[] nums = {1, 2, };
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 创建数组用来缓存计算结果，并用作输出
     * 2ms 98.55%
     *
     * @param nums len>1
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] * nums[i - 1];
        }

        long temp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            arr[i] *= temp;
        }

        return arr;
    }

}
