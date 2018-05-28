package index.leetcode_cn中级.回溯算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by mythss on 2018-05-27.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/93/
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class 全排列 {

    private int length;
    private List<List<Integer>> result = new LinkedList<>();

    @Test
    public void go() {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));

    }

    /**
     * 82.9%
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        length = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        if (length == 0) {
            return result;
        }

        int[] buffer = new int[length];
        dfs(nums, buffer, 0, result);

        return result;
    }

    /**
     * 第一个位置有3种选择，第二个有两种，第三个有一种
     */
    private void dfs(int[] nums, int[] buffer, int level, List<List<Integer>> result) {
        if (level == length) {
            //完成
            List<Integer> temp = new ArrayList<>(buffer.length);
            for (int i = 0; i < buffer.length; i++) {
                temp.add(buffer[i]);
            }
            result.add(temp);
            return;
        }

        //遍历当前数字num[x]对应的数组（除索引x以外其他）
        for (int i = 0; i < nums.length; i++) {
            buffer[level] = nums[i];
            dfs(copyArr(nums, nums[i]), buffer, level + 1, result);
        }
    }

    /**
     * 给下层的数组去掉当前元素
     *
     * @param nums
     * @param i
     * @return
     */
    private int[] copyArr(int[] nums, int i) {
        int[] arr = new int[nums.length - 1];
        int k = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == i) {
                continue;
            }

            arr[k++] = nums[j];
        }
        return arr;
    }

    private void dfs2(int[] nums, int level) {
        if (level == nums.length) {
            //此时nums完成交换
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            result.add(temp);
            return;
        }

        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);
            dfs2(nums, level + 1);
            //复原
            swap(nums, i, level);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<List<Integer>> permute_1(int[] nums) {
        if (nums.length == 0) {
            return result;
        }

        dfs2(nums, 0);

        return result;
    }
}
