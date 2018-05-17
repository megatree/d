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

        if (len == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> temp = new LinkedList<>();
                for (int i = 0; i < len; i++) {
                    temp.add(nums[i]);
                }
                result.add(temp);
                return result;
            } else {
                return result;
            }
        }

        //数组长度大于3
        Arrays.sort(nums);

        //先固定一个元素
        int stick = 0;
        int start = stick + 1;
        int end = len - 1;

        boolean interrupt = false;
        List<Integer> midResult;

        int lastStick = -1;
        int lastStart = -1;


        //在剩余元素中遍历
        while (stick < len - 2) {
            int nStick = nums[stick];

            if (nStick > 0) {
                //此时已经不能找到合理答案了
                break;
            }

            while (start < end) {

                if (nStick < 0 && nums[end] < 0) {
                    //也不可能
                    interrupt = true;
                    break;
                }

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
                    if (result.size() > 0 && lastStart == nums[start] && lastStick == nStick) {
                        start++;
                    } else {
                        //未发生重复
                        midResult = new LinkedList<>();
                        midResult.add(nStick);
                        midResult.add(nums[start]);
                        midResult.add(nums[end]);
                        result.add(midResult);

                        //替换last
                        lastStart = nums[start];
                        lastStick = nStick;

                        start++;
                        end--;
                    }
                }


            }

            if (interrupt) {
                break;
            }

            stick++;
            start = stick + 1;

            while (end < len - 1 && start < end && nums[stick] + nums[start] + nums[end] < 0) {
                end++;
            }
        }

        return result;
    }
}