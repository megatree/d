package index.leetcode_cn中级.设计问题;

import index.leetcode_cn.树.TreeNode;
import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-06-01.
 */
public class 序列化和反序列化二叉树 {

    @Test
    public void go() {
        TreeNode root = null;

        Codec codec = new Codec();
        codec.deserialize(codec.serialize(root));
    }

    public static class Codec {

        private int index = -1;
        private String[] arr = null;
        /**
         * 序列化，先序遍历
         * null用#表示
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if (root==null){
                sb.append("#,");
                return sb.toString();
            }
            sb.append(root.val).append(",");
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            index++;
            if (arr==null){
                arr = data.split(",");
            }
            TreeNode root = null;
            if (!"#".equals(arr[index])){
                root = new TreeNode(Integer.parseInt(arr[index]));
                root.left = deserialize(data);
                root.right = deserialize(data);
            }
            return root;
        }
    }
}
