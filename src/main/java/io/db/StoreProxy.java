package io.db;

import io.domain.Item;
import io.domain.Store;

class StoreProxy extends Store {

    DbEngine engine;

    public StoreProxy(DbEngine engine) {
        this.engine = engine;
        engine.readItems((itemID, name, count, price) -> {
            items.add(new ItemProxy(itemID, name, count, price, engine));
        });
    }

    @Override
    public Item createItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        return new ItemProxy(id, name, count, price, engine);
    }
}
