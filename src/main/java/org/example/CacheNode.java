package org.example;

import org.example.EvictionStrategies.IEvictionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CacheNode<K,V> {

    private int Id;
    private Map<K,V> cache;
    private IEvictionStrategy evictionStrategy;

    public CacheNode(IEvictionStrategy evictionStrategy){
        cache = new HashMap<>();
        this.evictionStrategy = evictionStrategy;
    }
    public int getNodeId(){
        return Id;
    }
    public Future<Void> put(K key, V value) {
        return null;
    }

    public Future<V> get(K key) {
        return null;
    }

    public Future<Void> remove(K key) {

        cache.remove(key);
        evictionStrategy.notify(key,CacheOperation.DELETE);
        return CompletableFuture.completedFuture(null);
    }

}
