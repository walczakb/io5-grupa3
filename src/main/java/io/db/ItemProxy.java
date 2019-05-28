package io.db;

import io.domain.Item;
import io.sqldb.SqlDbEngine;
import io.sqldb.SqlDbFactory;

class ItemProxy extends Item {
    private int id;
    private final SqlDbEngine db;

    public ItemProxy(String name, int count, int price, int id) {
        super(name, count, price);
        this.id = id;
        db = new SqlDbFactory().engine();
    }

    @Override
    public void update(String name, int count, int price) {
        db.updateItem(id, name, count, price);
    }
}
