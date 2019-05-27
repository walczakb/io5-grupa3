package io.db;

import io.domain.Store;

class StoreProxy extends Store {

    private DbEngine engine;
    private boolean dbSynced;

    public StoreProxy(DbEngine engine) {
        this.engine = engine;
        dbSynced = false;
    }

    protected ItemProxy createItem (String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        return new ItemProxy(name, count, price, id, engine);
    }
}
