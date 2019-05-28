package io.db;

import io.domain.Store;

public class Database {
    public static Store loadStore(DbEngine engine) {
        return new StoreProxy(engine);
    }
}
