package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database implements DbGateway {
    private final DbEngine engine;

    public Database(DbEngine engine) { this.engine = engine; }

    public Store loadStore() {
        List<Item> init = new ArrayList<>();
        engine.readItems((id, name, count, price) -> {
            init.add(new ItemProxy(name, count, price, id, engine));
        });
        StoreProxy store = new StoreProxy(init, engine);
        return store;
    }
}
