package io.db;

import io.domain.Item;
import io.domain.Store;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private final DbEngine engine;

    public Database(DbEngine engine) { this.engine = engine; }

    public Store loadStore() {
        StoreProxy store = new StoreProxy(engine);
        engine.readItems((id, name, count, price) -> {
            store.firstAddItem(name, count, price, id);
        });
        return store;
    }

}
