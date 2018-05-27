package index.leetcode_cn中级.回溯算法;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    @Test
    public void go() {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));

        for (int i = 0; i < arr.length; i++) {

        }
    }


    private int length;

    public List<List<Integer>> permute(int[] nums) {
        length = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        if (length == 0) {
            return result;
        }
//        List<Integer> buffer = new ArrayList<>(length);
//        for (int i = 0; i < length; i++) {
//            buffer.add(0);
//        }

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
            result.add(Arrays.stream(buffer).boxed().collect(toList()));
            return;
        }

        //遍历当前数字num[x]对应的数组（除索引x以外其他）
        for (int i = 0; i < length; i++) {
            if (i<level){
                continue;
            }

            buffer[level] = nums[i];
            dfs(nums, buffer, level + 1, result);
        }
    }
}
