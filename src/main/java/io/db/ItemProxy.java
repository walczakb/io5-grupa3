package io.db;

import io.domain.Item;

class ItemProxy extends Item {
    private int id;
    private DbEngine engine;

    public ItemProxy(DbEngine engine, int id, String name, int count, int price) {
        super(name, count, price);
        this.id = id;
        this.engine = engine;
    }

    @Override
    public void update(String name, int count, int price) {
        engine.updateItem(id, name, count, price);
        super.update(name, count, price);
    }
}
