package index.leetcode_cn.树;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-16.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/51/
 * <p>
 * 前提：升序排列的有序数组
 * 目标：转换为一棵高度平衡二叉搜索树
 *
 * 中序遍历
 */
public class 将有序数组转换为二叉搜索树 {

    @Test
    public void go() {


    }

    /**
     * 由于是有序数组，因此数组中间元素作为根节点，左右元素再分别递归
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);


        return node;
    }
}
