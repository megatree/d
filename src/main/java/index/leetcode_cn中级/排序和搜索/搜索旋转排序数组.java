package index.leetcode_cn中级.排序和搜索;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-31.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/102/
 */
public class 搜索旋转排序数组 {

    @Test
    public void go() {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};

        assert search(arr1, 0) == 4;
        assert search(arr1, 3) == -1;
    }

    @Test
    public void go2() {
        int[] arr1 = {1, 3};

        search(arr1, 3);

    }

    /**
     * 12ms 67.78%
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        //二分法查找分界中点
        int p = 0;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                p = mid;
                break;
            }

            if (nums[mid] > nums[r]) {
                l = mid;
                continue;
            }

            if (nums[mid] < nums[l]) {
                r = mid;
                continue;
            }

            if (l == mid) {
                p = r;
                break;
            }

            //有可能是正序
            l = mid;
        }

        int minIndex = 0;
        if (p != len - 1) {
            minIndex = p + 1;
        }
        if (target < nums[minIndex] || target > nums[p]) {
            return -1;
        }

        //没有旋转的升序数组
        if (p == len - 1) {
            return binarySearch(nums, 0, len - 1, target);
        } else if (nums[0] <= target && target <= nums[p]) {
            return binarySearch(nums, 0, p, target);
        } else {
            return binarySearch(nums, p + 1, len - 1, target);
        }
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        int l = start;
        int r = end;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (l == mid) {
                l++;
                continue;
            }

            if (nums[mid] > target) {
                r = mid;
                continue;
            }

            if (nums[mid] < target) {
                l = mid;
                continue;
            }

            l = mid;
        }
        return -1;
    }

}
