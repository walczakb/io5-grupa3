package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.List;

class StoreProxy extends Store {

    private DbEngine engine;

    public StoreProxy(List<Item> init, DbEngine engine) {
        super(init);
        this.engine = engine;
    }

    protected ItemProxy createItem (String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        return new ItemProxy(name, count, price, id, engine);
    }
}
