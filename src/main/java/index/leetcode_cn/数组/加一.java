package index.leetcode_cn.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-05-13.
 * <p>
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 * <p>
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * 大数相加简版
 */
public class 加一 {

    @Test
    public void t() {
        int[] arr = {4, 3, 2, 1};
        int[] arr2 = {9, 9, 9, 9};

        System.out.println(Arrays.toString(plusOne(arr)));
        System.out.println(Arrays.toString(plusOne(arr2)));

    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;

        if (digits[length - 1] < 9) {
            digits[length - 1] += 1;
            return digits;
        }

        //最后一位为9
        int unprocessed = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (unprocessed == 0) {
                //本位不需要加一
                continue;
            }

            if (digits[i] < 9) {
                digits[i] += unprocessed;
                unprocessed--;
                continue;
            }

            //本位为9，则加1变为0，那么下一位也需要加一
            digits[i] = 0;
        }

        int[] result;
        if (unprocessed > 0) {
            //还未处理，数组加一位
            result = new int[length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, length);
        } else {
            result = digits;
        }
        return result;
    }

}
