package index.linkedlist;

import java.io.Serializable;

/**
 * Created by wangzhe.bj on 2017/11/13.
 */
public class MyLinkedList<E> implements Cloneable, Serializable {

    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
    }

    public void add(E element) {
        addLast(element);
    }

    private void addLast(E element) {
        final Node<E> last = tail;
        final Node<E> newNode = new Node<>(last, element, null);
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        tail = newNode;
        size++;
    }

    private void addFirst(E element) {
        final Node<E> h = head;
        final Node<E> newNode = new Node<>(null, element, h);
        if (h == null) {
            head = tail = newNode;
        } else {
            h.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void add(int index, E element) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size - 1) {
            addLast(element);
            return;
        }

        Node<E> t = node(index);
        Node<E> prev = t.prev;
        Node<E> newNode = new Node<>(prev, element, t);
        if (prev != null) {
            prev.next = newNode;
        }
        t.prev = newNode;
        size++;
    }

    public E remove(int index) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }

        return unlink(node(index));
    }

    private E unlinkFirst(Node<E> f) {
        final E e = f.item;
        final Node<E> next = f.next;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
            f.next=null;
        }
        size--;
        return e;
    }

    private E unlinkLast(Node<E> l) {
        final E e = l.item;
        final Node<E> prev = l.prev;
        tail = prev;
        if (prev == null){
            head = null;
        }else {
            prev.next = null;
            l.prev = null;
        }
        size--;
        return e;
    }

    private E unlink(Node<E> node) {
        final E e = node.item;
        final Node<E> prev = node.prev;
        final Node<E> next = node.next;

        if (prev==null){
            head = next;
        }else{
            prev.next = next;
            node.prev = null;
        }

        if (next==null){
            tail = prev;
        }else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        return e;
    }


    public E get(int index) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }

        Node<E> node = node(index);
        return node.item;

    }

    /**
     * 按照索引查找结点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        if (index == 0) {
            return head;
        } else if (index == size - 1) {
            return tail;
        } else {
            int mid = size / 2;
            Node<E> t = null;
            if (index <= mid) {
                t = head;
                for (int i = 0; i <= index; i++) {
                    if (i == index) {
                        return t;
                    }
                    t = t.next;
                }
            } else {
                t = tail;
                for (int i = size - 1; i >= index; i--) {
                    if (i == index) {
                        return t;
                    }
                    t = t.prev;
                }
            }
            return t;
        }
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(head.item.toString());
        sb.append(":");
        sb.append(tail.item.toString());
        sb.append("\n");
        sb.append(head.toString());
        return sb.toString();
    }

    private static class Node<E> {
        E       item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[" + item.toString() + "]<-->");
            if (next == null) {
                String r = stringBuilder.toString();
                return r.substring(0, r.length() - 2);
            }
            stringBuilder.append(next.toString());
            return stringBuilder.toString();
        }
    }
}
