package org.example.WriteStrategies;

public class WriteStrategyFactory {

    public static IWriteStrategy getWriteStrategy(WriteStrategy writeStrategy){

        switch (writeStrategy){
            case WRITE_BACK -> {
                return new WriteBackCacheWriteStrategy();
            }
            case WRITE_THROUGH -> {
                return new WriteThroughCacheWriteStrategy();
            }
            default -> {
                return null;
            }
        }

    }

}
