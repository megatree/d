package index.collections.linkedlist;

/**
 * Created by wangzhe.bj on 2018/3/23.
 */
public class DoubleNode {

    public int data;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (prev!=null){
            stringBuilder.append("<-");
        }
        stringBuilder.append("[" + data + "]->");
        if (next == null) {
            String r = stringBuilder.toString();
            return r.substring(0, r.length() - 2);
        }
        stringBuilder.append(next.toString());
        return stringBuilder.toString();
    }
}
