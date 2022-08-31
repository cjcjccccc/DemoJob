package cjc.myhashmap;

public interface MyMap<K,V> {

    int size();

    boolean isEmpty();

    V get(K key);

    V put(K k, V v);

    V remove(K k);

    V update(K k, V v);


    interface Entry<K,V>{

        K getKey();

        V getValue();
    }
}
