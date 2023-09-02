package org.example.EvictionStrategies;

import org.example.CacheOperation;

public interface IEvictionStrategy<K> {

    void notify(K key, CacheOperation operation);
    K evict();
}
