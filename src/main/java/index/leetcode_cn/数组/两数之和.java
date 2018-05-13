package index.leetcode_cn.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-05-13.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 *
 * 第三种方式可以使用 hashmap
 */
public class 两数之和 {

    @Test
    public void go() {

        int[] arr = {-1, -2, -3, -4, -5};


        System.out.println(Arrays.toString(twoSum(arr, -8)));
    }

    /**
     * 先排序，然后两个指针分别从首尾像中间扫描
     * 没有结果则返回空数组
     *
     *  99.57%  快
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] empty = {};
        if (nums == null || nums.length < 2) {
            return empty;
        }

        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);

        Arrays.sort(nums);

        int head = 0;
        int tail = nums.length - 1;
        int[] result = new int[2];
        boolean flag = false;

        while (head < tail) {
            int sum = nums[head] + nums[tail];

            if (sum == target) {
                result[0] = nums[head];
                result[1] = nums[tail];
                flag = true;
                break;
            }

            if (sum < target) {
                head++;
                continue;
            }

            if (sum > target) {
                tail--;
                continue;
            }
        }

        //原数组里找索引
        if (flag) {
            //存原数组两数下标
            int[] indexs = new int[2];
            indexs[0] = -1;
            indexs[1] = -2;

            for (int i = 0; i < copy.length; i++) {
                //从左向右遍历，当找到预期的数时，记录下两个数的坐标
                //当两数数值相等，则使第二坐标继续遍历，寻找相同数值
                //此过程中，第一坐标使其不被重新赋值
                if (copy[i] == result[0] && indexs[0] != indexs[1]) {
                    indexs[0] = i;
                }
                if (copy[i] == result[1]) {
                    indexs[1] = i;
                }
                if (indexs[0] != indexs[1] && indexs[0] != -1 && indexs[1] != -2) {
                    break;
                }
            }
            Arrays.sort(indexs);
            return indexs;
        }

        return empty;
    }

    /**
     * 11.62%  慢
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        int[] empty = {};
        if (nums == null || nums.length < 2) {
            return empty;
        }

        int head = 0;
        int tail = nums.length - 1;

        while (head < tail && nums[head] + nums[tail] != target) {
            tail--;

            if (head == tail) {
                head++;
                tail = nums.length - 1;
            }
        }

        if (head < tail && nums[head] + nums[tail] == target) {
            return new int[]{head, tail};
        }

        return empty;
    }

}
