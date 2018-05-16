package index.leetcode_cn.树;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-15.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/48/
 */
public class 验证二叉搜索树 {

    @Test
    public void go() {

    }

    public int lastValue = -1;

    /**
     * 0ms 1ms
     * 性能优秀
     *
     * @param root
     * @return
     */
    public boolean isValidBST_1(TreeNode root) {
        if (root == null) {
            //空树定义为是
            return true;
        }

        boolean left = isValidBST(root.left);

        //中序遍历，保证每次遍历都是升序
        if (lastValue == -1) {
            //初始化
            lastValue = root.val;
        } else {
            //判断，如果不是升序直接false
            if (lastValue >= root.val) {
                return false;
            }

            //赋值
            lastValue = root.val;
        }

        boolean right = isValidBST(root.right);

        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

}
