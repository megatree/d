package index.leetcode_cn.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-05-12.
 * <p>
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 */
public class 存在重复 {

    @Test
    public void go() {
        int[] arr1 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] arr2 = {1, 2, 3, 4};

//        assert containsDuplicate(arr1);
//        assert !containsDuplicate(arr2);

        int[] arr3 = {9, 3, 6, 1, 10, 0, 9};
//        assert containsDuplicate_copy(arr3);

        assert containsDuplicate(arr3);


    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }


    public boolean containsDuplicate_copy(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && j + 1 != i) {

                    break;
                }
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
