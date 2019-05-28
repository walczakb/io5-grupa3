package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.HashMap;
import java.util.Map;

public class Database {

    public static Store loadStore(DbEngine engine) {
        Store store = new Store();
        ItemProxy.ids = new HashMap<>();
        engine.readItems((id, name, count, price) -> {
            Item item  = store.addItem(name, count, price);
            ItemProxy.ids.put(item, id);
        });
        return new StoreProxy(engine, store);
    }
}
