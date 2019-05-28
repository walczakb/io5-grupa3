package io.db;

import io.domain.Item;
import io.domain.Store;

class StoreProxy extends Store {
    private DbEngine engine;

    public StoreProxy(DbEngine engine) {
        super();
        this.engine = engine;
        engine.readItems((itemId, name, count, price) -> {
            items.add(new ItemProxy(engine, itemId, name, count, price));
        });
    }

    @Override
    protected Item createItem(String name, int count, int price) {
        return new ItemProxy(engine, engine.insertItem(name, count, price), name, count, price);
    }
}
