package io.db;

import io.domain.Item;
import io.domain.Store;

class StoreProxy extends Store {
    DbEngine engine;

    public StoreProxy(DbEngine engine) {
        this.engine = engine;
        this.engine.readItems((id, name, count, price) -> {
            items.add(new ItemProxy(name, count, price, id, engine));
        });
    }

    @Override
    protected Item createItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        return new ItemProxy(name, count, price, id, engine);
    }
}
