package index.leetcode_cn中级.其他;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-06-05.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/121/
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class 求众数 {

    @Test
    public void go() {


    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }

    /**
     * 由于众数出现次数大于一半，因此其应该是计数大于0的那个数
     * @param nums
     * @return
     */
    public int majorityElement_(int[] nums) {
        int count = 0;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count==0){
                //若计数为0，更换cur
                cur = nums[i];
            }

            if (cur==nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return cur;
    }
}
