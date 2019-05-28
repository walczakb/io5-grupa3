package io.db;

import io.domain.Item;

class ItemProxy extends Item {
    DbEngine engine;
    int id;

    public ItemProxy(int id, String name, int count, int price, DbEngine engine) {
        super(name, count, price);
        this.engine = engine;
        this.id = id;
    }

    @Override
    public void update(String name, int count, int price) {
        engine.updateItem(id, name, count, price);
        super.update(name, count, price);
    }
}
