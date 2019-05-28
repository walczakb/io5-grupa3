package io.db;

import io.domain.Item;
import io.domain.Store;
import io.sqldb.SqlDbEngine;
import io.sqldb.SqlDbFactory;

class StoreProxy extends Store {
    private final SqlDbEngine db;

    StoreProxy() {
        super();
        db = new SqlDbFactory().engine();
    }

    @Override
    protected Item createItem(String name, int count, int price) {
        int id = db.insertItem(name, count, price);
        return new ItemProxy(name, count, price, id);
    }
}
