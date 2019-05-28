package io.db;

import io.domain.Item;

import java.util.Map;

class ItemProxy extends Item {

    protected final DbEngine engine;
    protected static Map<Item, Integer> ids;

    public ItemProxy(DbEngine engine, String name, int count, int price){
        super(name,count,price);
        this.engine = engine;
    }

    public void update(String name, int count, int price) {
        int id = ids.get(this);
        engine.updateItem(id, name, count, price);
        super.update(name, count, price);
    }

}
