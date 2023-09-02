package org.example;

import org.example.Database.DatabaseAdapter;
import org.example.EvictionStrategies.EvictionStrategy;
import org.example.EvictionStrategies.EvictionStrategyFactory;
import org.example.EvictionStrategies.IEvictionStrategy;
import org.example.WriteStrategies.IWriteStrategy;
import org.example.WriteStrategies.WriteStrategy;
import org.example.WriteStrategies.WriteStrategyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class DistributedCache<K,V> implements Cache<K,V>{

    private int numberOfNodes;
    private int numberOfReplicas;
    private int preFetchSize;
    private IEvictionStrategy evictionStrategy;
    private IWriteStrategy writeStrategy;
    private DatabaseAdapter<K,V> databaseAdapter;

    private ConsistentHashing consistentHashing;
    private List<CacheNode> cacheNodes;

    public DistributedCache(EvictionStrategy evictionStrategy, WriteStrategy writeStrategy,
                            int numberOfNodes, int numberOfReplicas, int preFetchSize, DatabaseAdapter<K,V> databaseAdapter){

        this.numberOfNodes = numberOfNodes;
        this.numberOfReplicas = numberOfReplicas;
        this.preFetchSize = preFetchSize;
        this.writeStrategy = WriteStrategyFactory.getWriteStrategy(writeStrategy);
        this.evictionStrategy = EvictionStrategyFactory.getEvictionStrategy(evictionStrategy);
        this.databaseAdapter = databaseAdapter;
        List<CacheNode> cacheNodes = new ArrayList<>();
        for(int i=0;i<numberOfNodes;++i){
            cacheNodes.add(new CacheNode(this.evictionStrategy));
        }
        this.consistentHashing = new ConsistentHashing(numberOfReplicas,cacheNodes);
    }

    @Override
    public Future<Void> put(K key, V value) {
        return null;
    }

    @Override
    public Future<V> get(K key) {
        return null;
    }

    @Override
    public Future<Void> remove(K key) {
        CacheNode cacheNode = consistentHashing.get(String.valueOf(key));

        if(cacheNode!=null){
            return cacheNode.remove(key);
        }

        return CompletableFuture.completedFuture(null);
    }
}
