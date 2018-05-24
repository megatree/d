package index.leetcode_cn中级.树和图;

import index.leetcode_cn.树.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhe.bj on 2018-05-24.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/85/
 * <p>
 * 递归非递归两种实现
 */
public class 中序遍历二叉树 {

    @Test
    public void go() {

    }

    /**
     * 递归中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        inorder(list, root);
        return list;
    }

    public void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}
