package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.HashMap;
import java.util.Map;

public class Database {
    public static Store loadStore(DbEngine engine) {
        return new StoreProxy(engine);
//        return store;
    }

//    public void addItem(Item item) {
//        int id = engine.insertItem(item.name(), item.count(), item.price());
//        ids.put(item, id);
//    }
//
//    public void updateItem(Item item) {
//        int id = ids.get(item);
//        engine.updateItem(id, item.name(), item.count(), item.price());
//    }
}
