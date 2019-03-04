package index.leetcode;

import index.leetcode_cn.树.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhe.bj on 2019-03-04.
 * <p>
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class 二叉树展开为链表 {

    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();

    @Before
    public void setup() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        TreeNode t2 = root.left;
        TreeNode t5 = root.right;

        t2.left = new TreeNode(3);
        t2.right = new TreeNode(4);

        t5.right = new TreeNode(6);
    }

    @Test
    public void go() {
        flatten(root);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    /**
     * 队列 先序
     *
     * @param root
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }

        preOrder(root);

        TreeNode r = queue.poll();
        r.left = null;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            t.left = null;
            t.right = null;
            r.right = t;
            r = r.right;
        }


    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        preOrder(root.left);
        preOrder(root.right);
    }


    /**
     * 解法2，原地转换
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        while (root!=null){
            TreeNode right = root.right;
            TreeNode left = root.left;

            if (left!=null){
                while (left.right!=null){
                    left = left.right;
                }

                //遍历到左子树最右子节点
                left.right = right;
                root.right = root.left;
            }
            root.left = null;
            root = root.right;
        }

    }

}
