package index.util;

import index.binarytree.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class TreeUtils {

    public static TreeNode createTree() {
        TreeNode t41 = new TreeNode(3);
        TreeNode t42 = new TreeNode(8);

        TreeNode t43 = new TreeNode(18);

        TreeNode t31 = new TreeNode(t41, t42, 7);
        TreeNode t32 = new TreeNode(t43, null, 19);
        TreeNode t33 = new TreeNode(41);
        TreeNode t34 = new TreeNode(50);

        TreeNode t21 = new TreeNode(t31, t32, 15);
        TreeNode t22 = new TreeNode(t33, t34, 44);

        TreeNode t1 = new TreeNode(t21, t22, 30);
        return t1;
    }

    public static Serializer serializer() {
        return new Serializer();
    }

    public static class Serializer {

        private int index = 0;

        /**
         * 序列化
         *
         * @param node
         * @return
         */
        public String serialize(TreeNode node) {
            StringBuilder sb = new StringBuilder();
            if (node == null) {
                sb.append("#,");
                return sb.toString();
            }
            sb.append(node.getValue() + ",");
            sb.append(serialize(node.getLeft()));
            sb.append(serialize(node.getRight()));
            return sb.toString();

        }

        /**
         * 反序列化
         */
        public TreeNode deserialize(String str) {
            index++;
            String[] arr = str.split(",");
            TreeNode node = null;
            if (!"#".equals(arr[index])) {
                node = new TreeNode(Integer.valueOf(arr[index]));
                node.setLeft(deserialize(str));
                node.setRight(deserialize(str));
            }

            return node;
        }
    }

    /**
     * _______________30
     * ____________/     \
     * _________15        44
     * ________/  \      /  \
     * _______7   19   41   50
     * _____/ \   /
     * ____3  8  18
     *
     * @return
     */
    public static void main(String[] args) {


        System.out.println(TreeUtils.serializer().serialize(createTree()));

    }


}
