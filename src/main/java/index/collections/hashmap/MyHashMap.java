package index.collections.hashmap;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2017/11/13.
 */
public class MyHashMap<K, V> implements Cloneable, Serializable {

    private static final float DEFAULT_LOADFACTOR = 0.75f;
    private static final int   DEFAULT_CAPACITY   = 1 << 4;

    private final float         loadFactor;
    private       Entry<K, V>[] table;
    private int size = 0;
    /**
     * 已使用的数组长度
     */
    private int use  = 0;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOADFACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        this.table = new Entry[initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY];
        this.loadFactor = loadFactor;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public V get(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        V v = null;
        while (e != null) {
            Object k = e.key;
            if (k == key || k.equals(key)) {
                v = e.value;
            }
            e = e.next;
        }
        return v;
    }


    public V put(K key, V value) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        V old = null;
        if (e == null) {
            table[index] = new Entry<>(key, value, null);
            use++;
            size++;

            if (use >= table.length * loadFactor) {
                resize();
            }
        } else {
            while (e != null) {
                Object k = e.key;
                if (k == key || k.equals(key)) {
                    old = e.value;
                    e.value = value;
                    return old;
                }
                e = e.next;
            }
            Entry<K, V> temp = table[index];
            old = temp.value;
            table[index] = new Entry<>(key, value, temp);
            size++;
        }
        return old;
    }


    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        Entry<K, V> prev = null;
        V oldv = null;
        while (e != null) {
            Object k = e.key;
            if (k == key || k.equals(key)) {
                oldv = e.value;
                if (prev == null) {
                    //当前元素为第一个元素
                    table[index] = null;
                    use--;

                } else {
                    prev.next = e.next;
                }

                size--;
                break;
            }
            prev = e;
            e = e.next;
        }


        return oldv;
    }


    public void clear() {
        Arrays.fill(table, null);
        size = 0;
        use = 0;
    }

    private int hash(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % table.length;
        return index;
    }

    private void resize() {

        int newCapacity = table.length << 1;
        Entry<K, V>[] oldTable = table;
        table = new Entry[newCapacity];
        use = 0;
        size = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                Entry<K, V> e = oldTable[i];
                while (e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
        }


    }

    public static class Entry<K, V> {
        K           key;
        V           value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
