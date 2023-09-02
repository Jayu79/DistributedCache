package org.example;

import java.util.concurrent.Future;

public interface Cache<K,V> {

    Future<Void> put(K key, V value);
    Future<V> get(K key);
    Future<Void> remove(K key);

}
