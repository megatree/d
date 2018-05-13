package index.leetcode_cn.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-05-12.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class 只出现一次的数字 {

    @Test
    public void main() {
        assert singleNumber(new int[]{2, 2, 1}) == 1;
        assert singleNumber(new int[]{4, 1, 2, 1, 2}) == 4;

    }


    /**
     * 异或
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++)
            num ^= nums[i];
        return num;
    }

    public int singleNumber_1(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        Arrays.sort(nums);

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        return 0;
    }

}
