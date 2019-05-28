package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.ArrayList;
import java.util.Map;

class StoreProxy extends Store {

    protected final DbEngine engine;

    public StoreProxy(DbEngine engine, Store store){
        for(Item item : store.items()) {
            ItemProxy itemProxy = new ItemProxy(engine, item.name(), item.count(), item.price());
            this.items.add(itemProxy);
            int id = ItemProxy.ids.get(item);
            ItemProxy.ids.remove(item);
            ItemProxy.ids.put(itemProxy, id);
        }
        this.observers = new ArrayList<>(store.observers());
        this.engine = engine;
    }

    public ItemProxy createItem(String name, int count, int price){
        int id = engine.insertItem(name, count, price);
        ItemProxy item = new ItemProxy(engine,name,count,price);
        ItemProxy.ids.put(item, id);
        return item;
    }

}
