package index.leetcode_cn中级.回溯算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhe.bj on 2018-05-28.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/94/
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class 子集 {

    private List<List<Integer>> result = new LinkedList<>();

    @Test
    public void go() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(subsets(arr));
    }

    /**
     * 2ms 98.48%
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        //空集
        result.add(new LinkedList<>());

        if (nums == null || nums.length == 0) {
            return result;
        }

        //全集
        List<Integer> tempList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            tempList.add(nums[i]);
        }
        result.add(tempList);

        if (nums.length == 1) {
            return result;
        }

        //单个
        for (int i = 0; i < nums.length; i++) {
            tempList = new LinkedList<>();
            tempList.add(nums[i]);
            result.add(tempList);
        }

        if (nums.length == 2) {
            return result;
        }

        //至此>=3
        //buffer 长度从2到len-1
        for (int i = 2; i < nums.length; i++) {
            int[] buffer = new int[i];
            dfs(nums, 0, -1, buffer);
        }

        return result;
    }

    /**
     * buffer 长度不固定，为2~nums.length-1
     */
    private void dfs(int[] nums, int level, int lastI, int[] buffer) {
        if (buffer.length == level) {
            List<Integer> list = new ArrayList<>(buffer.length);
            for (int i = 0; i < buffer.length; i++) {
                list.add(buffer[i]);
            }
            result.add(list);
            return;
        }

        for (int i = level; i < nums.length; i++) {
            //当前i应该在上个level的后面开始,因此跳过相等的i
            if (i <= lastI) {
                continue;
            }

            buffer[level] = nums[i];
            dfs(nums, level + 1, i, buffer);
        }

    }
}
