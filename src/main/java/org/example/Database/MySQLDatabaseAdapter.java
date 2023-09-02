package org.example.Database;

import java.util.concurrent.Future;

public class MySQLDatabaseAdapter<K,V> implements DatabaseAdapter<K,V>{
    @Override
    public Future<Void> put(K key,V value) {
        return null;
    }

    @Override
    public Future get(K key) {
        return null;
    }

    @Override
    public Future<Void> remove(K key) {
        return null;
    }
}
