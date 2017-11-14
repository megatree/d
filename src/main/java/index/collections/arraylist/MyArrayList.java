package index.collections.arraylist;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2017/11/13.
 */
public class MyArrayList<E> implements Serializable, Cloneable {

    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int      DEFAULT_CAPACITY  = 10;

    private Object[] elementData;
    private int size = 0;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("illegal capacity");
        }
    }

    public MyArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    public E get(int index) {
        if (rangeCheck(index)) {
            throw new IllegalArgumentException("index out of bounds");
        }

        return (E) elementData[index];
    }

    public E set(int index, E element) {
        if (rangeCheck(index)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        E old = (E) elementData[index];
        elementData[index] = element;
        return old;
    }

    public int size() {
        return size;
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        this.elementData[size++] = e;
        return true;
    }

    public E remove(int index) {
        if (rangeCheck(index)) {
            throw new IllegalArgumentException("index out of bounds");
        }

        E oldv = (E) elementData[index];

        int numMoved = size - 1 - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null;
        return oldv;
    }

    private boolean rangeCheck(int index) {
        return index >= size;
    }

    private void ensureCapacity(int minCapacity) {
        //检查初始容量
        if (elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        }

        //如果当前需要的最小容量大于当前数组长度，则需扩容
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    public void printInfo() {
        System.out.println("elementData.length:" + elementData.length);
        System.out.println("size:" + size);
    }
}
