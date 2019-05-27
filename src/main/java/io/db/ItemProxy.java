package io.db;

import io.domain.Item;

class ItemProxy extends Item {
    private int dbId;

    private DbEngine engine;

    public ItemProxy(String name, int count, int price, int id, DbEngine engine) {
        super(name, count, price);
        this.engine = engine;
        dbId = id;
    }

    @Override
    public void update(String name, int count, int price) {
        engine.updateItem(dbId, name, count, price);
        super.update(name, count, price);
    }
}
