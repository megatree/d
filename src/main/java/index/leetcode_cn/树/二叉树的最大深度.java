package index.leetcode_cn.树;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-15.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class 二叉树的最大深度 {

    @Test
    public void go() {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        t1.left = t2;
        t1.right = t3;

        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t3.left = t4;
        t3.right = t5;

        System.out.println(maxDepth(t1));
    }


    /**
     * 求最大深度，也就是计算左右子树最大深度，如此递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }

}
