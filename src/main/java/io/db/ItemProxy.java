package io.db;

import io.domain.Item;

class ItemProxy extends Item {
    private final int id;
    private final DbEngine engine;

    ItemProxy(String name, int count, int price, int id, DbEngine engine) {
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
