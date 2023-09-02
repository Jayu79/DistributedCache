package org.example.EvictionStrategies;

import org.example.CacheOperation;

public class LRUEvictionStrategy<K> implements IEvictionStrategy<K>{

    @Override
    public void notify(K key, CacheOperation operation) {

    }

    @Override
    public K evict() {
        return null;
    }
}
