package index.linkedlist;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class ComplexNode {

    private int value;
    private ComplexNode next;
    private ComplexNode sibling;

    public ComplexNode(int value) {
        this.value = value;
    }

    public ComplexNode(int value, ComplexNode next, ComplexNode sibling) {
        this.value = value;
        this.next = next;
        this.sibling = sibling;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ComplexNode getNext() {
        return next;
    }

    public void setNext(ComplexNode next) {
        this.next = next;
    }

    public ComplexNode getSibling() {
        return sibling;
    }

    public void setSibling(ComplexNode sibling) {
        this.sibling = sibling;
    }
}
