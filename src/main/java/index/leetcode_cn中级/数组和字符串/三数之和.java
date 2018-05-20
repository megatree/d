package index.leetcode_cn中级.数组和字符串;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhe.bj on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/75/
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class 三数之和 {

    @Test
    public void go() {
        int[] arr = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> r = threeSum(arr);
        r.forEach(list -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int len = nums.length;
        if (len < 3) {
            return result;
        }

        //数组长度大于3
        Arrays.sort(nums);

        //先固定一个元素
        int stick = 0;
        int start = stick + 1;
        int end = len - 1;
        int lastStick = nums[0];

        List<Integer> midResult;

        //在剩余元素中遍历
        while (stick < len - 2) {
            int nStick = nums[stick];

            //stick 不能重复
            if (stick != 0 && nStick == lastStick) {
                stick++;
                start = stick + 1;
                continue;
            }

            lastStick = nStick;


            if (nStick > 0) {
                //此时已经不能找到合理答案了
                break;
            }

            while (start < end) {

                int sum = nStick + nums[start] + nums[end];

                if (sum > 0) {
                    end--;
                    continue;
                }

                if (sum < 0) {
                    start++;
                    continue;
                }

                if (sum == 0) {
                    //判断重复
                    midResult = new LinkedList<>();
                    midResult.add(nStick);
                    midResult.add(nums[start]);
                    midResult.add(nums[end]);
                    result.add(midResult);

                    //跳过重复结点
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    //此时start为最后一个重复结点，须有右移

                    while (start < end && nums[end - 1] == nums[end]) {
                        end--;
                    }

                    start++;
                    end--;
                }
            }

            stick++;
            start = stick + 1;

        }

        return result;
    }
}