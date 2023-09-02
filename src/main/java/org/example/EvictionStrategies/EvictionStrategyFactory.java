package org.example.EvictionStrategies;

public class EvictionStrategyFactory {

    public static IEvictionStrategy getEvictionStrategy(EvictionStrategy evictionStrategy){

        switch (evictionStrategy){
            case LRU -> {
                return new LRUEvictionStrategy();
            }
            case LFU -> {
                return new LFUEvictionStrategy();
            }
            default -> {
                return null;
            }
        }
    }

}
