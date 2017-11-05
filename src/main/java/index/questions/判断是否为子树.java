package index.questions;

import index.binarytree.TreeNode;
import index.util.TreeUtils;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class 判断是否为子树 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTree();
        TreeNode r2 = root.getRight();

        System.out.println(HasSubTree(root, r2));

    }


    /**
     * 判断本节点或者子节点的树结构是否相同
     *
     * @param tree1
     * @param tree2
     * @return
     */
    public static boolean HasSubTree(TreeNode tree1, TreeNode tree2) {
        boolean hasSubTree = false;
        if (tree1 != null && tree2 != null) {
            if (tree1.getValue() == tree2.getValue()) {
                hasSubTree = AhasB(tree1, tree2);
            }
            if (!hasSubTree) {
                hasSubTree = HasSubTree(tree1.getLeft(), tree2) || HasSubTree(tree1.getRight(), tree2);
            }
         }

        return hasSubTree;

    }

    /**
     * 由两个根节点对比树是否相同
     *
     * @param tree1
     * @param tree2
     * @return
     */
    public static boolean AhasB(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null) {
            return false;
        }

        if (tree2 == null) {
            return true;
        }

        if (tree1.getValue() == tree2.getValue()) {
            return AhasB(tree1.getLeft(), tree2.getLeft()) && AhasB(tree1.getRight(), tree2.getRight());
        }

        return false;
    }
}
