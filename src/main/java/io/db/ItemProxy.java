package io.db;

import io.domain.Item;

class ItemProxy extends Item {
    public ItemProxy(String name, int count, int price) {
        super(name, count, price);
    }

    public ItemProxy(String name, int count, int price, int id, DbEngine engine) {
        super(name, count, price);
        this.id = id;
        this.engine = engine;
    }

    int id;
    DbEngine engine;

    @Override
    public void update(String name, int count, int price) {
        engine.updateItem(id, name, count, price);
        super.update(name, count, price);
    }
}
