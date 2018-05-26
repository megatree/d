package index.leetcode_cn中级.树和图;

import index.leetcode_cn.树.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhe.bj on 2018-05-25.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/87/
 */
public class 从前序与中序遍历序列构造二叉树 {

    @Test
    public void go() {

    }

    /**
     * 根据前序中序生成二叉树
     * 中序中间节点为根节点，左右为左右子树
     *
     * 4ms
     * 98.94%
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        //将中序遍历每个元素的值，索引 放入map
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return preIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode preIn(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }

        //前序数组第一个为头节点
        TreeNode head = new TreeNode(pre[preStart]);

        int inDex = map.get(pre[preStart]);
        head.left = preIn(pre, preStart + 1, preStart + inDex-inStart, in, inStart, inDex - 1, map);
        head.right = preIn(pre, preStart + inDex-inStart + 1, preEnd, in, inDex + 1, inEnd, map);
        return head;
    }
}
