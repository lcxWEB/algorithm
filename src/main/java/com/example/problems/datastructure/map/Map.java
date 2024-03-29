package com.example.problems.datastructure.map;

/**
 * @Author: lcx
 * @Date: 2019/1/28 13:00
 * @Description:
 */

public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();

}
