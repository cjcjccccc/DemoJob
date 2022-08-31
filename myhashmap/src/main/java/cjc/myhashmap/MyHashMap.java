package cjc.myhashmap;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {

    //    默认容量: 16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    //    默认加载因子: 0.75
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //    数组
    Node[] talbe;

    int size;


    public MyHashMap() {
        this.size = 0;
    }


    //定义Node节点内部类,存储key-value
    static class Node<K, V> implements Entry<K, V> {

        int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        int index = hash % DEFAULT_INITIAL_CAPACITY;
        Node<K, V> first, e;

        first = talbe[index];
        if (first == null) {
            return null; //头节点为空,直接返回null
        } else if (first.hash == hash && first.key == key || (key != null && key.equals(first.key))) {
            return first.value;//头节点就是,直接返回
        } else if ((e = first.next) != null) {
            while ((e = e.next) != null) {//顺着单链表查找
                if (e.hash == hash && e.key == key || (key != null && key.equals(e.key))) {
                    return e.value;
                }
            }
        }
        return null;
    }

    @Override
    public V put(K k, V v) {

        Node<K, V> node;

        int index, hash;

        hash = hash(k);
        index = hash % DEFAULT_INITIAL_CAPACITY;
        node = new Node<>(hash, k, v, null);
//        首次put时创建数组
        if (talbe == null || talbe.length == 0) {
            this.talbe = new Node[DEFAULT_INITIAL_CAPACITY];
        }
//        考虑扩容
        if (size > talbe.length * DEFAULT_LOAD_FACTOR) {
            resize();
        }
//        数组该位置为空, 头部插入
        if (talbe[index] == null) {
            talbe[index] = node;
            size++;
            return v;
        } else {
            Node<K, V> head = talbe[index];
            Node<K, V> tail = null;
            while (head != null) {
//                如果hash值相同,就再根据equals判断
                if (hash(head.key) == hash(k) && k.equals(head.key)) {
                    head.value = v;
                    return v;
                }
                tail = head;
                head = head.next;
            }
            tail.next = node;
            size++;
            return v;
        }
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);
        int index = hash % DEFAULT_INITIAL_CAPACITY;
        Node<K, V> nodes = talbe[index];
        if (nodes != null) {
            if (nodes.getKey().equals(key)) {
                talbe[index] = nodes.next;
                size--;
            } else {
                while (!nodes.next.getKey().equals(key)) {
                    nodes = nodes.next;
                }
                V value = nodes.next.getValue();
                nodes.next = nodes.next.next;
                size--;
                return value;
            }
        }
        return null;
    }

    @Override
    public V update(K k, V v) {
        return put(k, v);
    }


    public Set<K> Keyset() {
        Set<K> kSet = new HashSet<>();
        for (Node nodes : talbe) {
            if (nodes != null) {
                while (nodes != null) {
                    kSet.add((K) nodes.getKey());
                    nodes = nodes.next;
                }
            } else {
                continue;
            }
        }
        return kSet;
    }

    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (Node nodes : talbe) {
            if (nodes != null) {
                while (nodes != null) {
                    values.add((V) nodes.getValue());
                    nodes = nodes.next;
                }
            } else {
                continue;
            }
        }
        return values;
    }


    public void print() {
        for (Node node : talbe) {
            Node nodes = node;
            if (nodes != null) {
                while (nodes != null) {
                    K key = (K) nodes.getKey();
                    V value = (V) nodes.getValue();
                    System.out.print(key + " : " + value + "\t");
                    nodes = nodes.next;
                }
                System.out.println();
            }
        }
    }


    private void resize() {
        int newCapacity = talbe.length << 2;
        Node<K, V>[] newTable = new Node[newCapacity];
        newTable = Arrays.copyOf(talbe, talbe.length);
        this.talbe = newTable;
    }


    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
