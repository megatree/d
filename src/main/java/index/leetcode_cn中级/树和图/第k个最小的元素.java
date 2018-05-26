package index.leetcode_cn中级.树和图;

import index.leetcode_cn.树.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by wangzhe.bj on 2018-05-26.
 */
public class 第k个最小的元素 {

    public int count  = 0;
    public int result = 0;

    @Test
    public void go() {

    }

    /**
     * 中序遍历第k个，即为第k小的数
     * 非递归
     * <p>
     * 2 ms
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        int i = 1;

        while (t != null || stack.size() > 0) {

            while (t != null) {
                stack.push(t);
                t = t.left;
            }

            //左侧触底
            if (stack.size() > 0) {
                t = stack.pop();

                if (i == k) {
                    return t.val;
                }
                i++;

                t = t.right;
            }
        }
        return 0;
    }

    /**
     * 递归方式
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        helper(root, k);

        return result;

    }

    public void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            helper(root.left, k);
        }

        //遍历到当前节点
        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        if (count > k) {
            return;
        }

        if (root.right != null) {
            helper(root.right, k);
        }
    }
}
