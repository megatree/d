package index.binarytree;

/**
 * Created by wangzhe.bj on 2017/10/12.
 */
public class BalancedTree {

    public static boolean isBalanceTree = true;

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        TreeNode l1 = new TreeNode(6);
        TreeNode r1 = new TreeNode(7);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(9);
        head.setLeft(l1);
        head.setRight(r1);
        l1.setLeft(l2);
        l2.setLeft(l3);

        System.out.println(isBalanced(head));

    }

    public static boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalanceTree;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.getLeft());
        int right = getDepth(root.getRight());

        if (Math.abs(left - right) > 1) {
            isBalanceTree = false;
        }

        return left > right ? left + 1 : right + 1;
    }
}
