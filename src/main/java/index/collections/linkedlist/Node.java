package index.collections.linkedlist;

/**
 * Created by wangzhe.bj on 2017/7/13.
 */
public class Node {

    public int  data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[" + data + "]->");
        if (next == null) {
            String r = stringBuilder.toString();
            return r.substring(0, r.length() - 2);
        }
        stringBuilder.append(next.toString());
        return stringBuilder.toString();
    }
}
