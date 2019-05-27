package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.HashMap;
import java.util.Map;

public class Database implements DbGateway {
    private final DbEngine engine;
    private Map<Item, Integer> ids;

    public Database(DbEngine engine) { this.engine = engine; }

    public Store loadStore() {
        Store store = new Store();
        ids = new HashMap<>();
        engine.readItems((id, name, count, price) -> {
            Item item = store.addItem(name, count, price);
            ids.put(item, id);
        });
        return store;
    }

    public void addItem(Item item) {
        int id = engine.insertItem(item.name(), item.count(), item.price());
        ids.put(item, id);
    }

    public void updateItem(Item item) {
        int id = ids.get(item);
        engine.updateItem(id, item.name(), item.count(), item.price());
    }
}
