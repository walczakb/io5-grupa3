package io.db;

import io.domain.Item;
import io.domain.Store;

class StoreProxy extends Store {
    private final DbEngine engine;

    StoreProxy(DbEngine engine) {
        this.engine = engine;
        engine.readItems((id, name, count, price) -> {
            ItemProxy item = new ItemProxy(name, count, price, id, engine);
            addItem(item);
        });
    }

    @Override
    protected Item createItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        return new ItemProxy(name, count, price, id, engine);
    }
}
