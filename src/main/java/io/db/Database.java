package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.HashMap;
import java.util.Map;

public class Database {
    public static Store loadStore(DbEngine engine) {
        StoreProxy store = new StoreProxy();
        Map<Item, Integer> ids = new HashMap<>();
        engine.readItems((id, name, count, price) -> {
            Item item = store.addItem(name, count, price);
            ids.put(item, id);
        });
        return store;
    }
}
