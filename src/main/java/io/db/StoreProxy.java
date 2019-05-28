package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StoreProxy extends Store {

    public StoreProxy(DbEngine engine) {
        this.engine = engine;
    }

    private List<Store.Observer> observers = new ArrayList<>();

    public void addObserver(Store.Observer observer) { observers.add(observer); }
    public void removeObserver(Store.Observer observer) { observers.remove(observer); }

    private List<Item> items = new ArrayList<>();

    private DbEngine engine;

    public List<Item> items() { return Collections.unmodifiableList(items); }

    public Item addItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        Item item = new ItemProxy(name, count, price, engine, id);
        items.add(item);
        for (Store.Observer observer : observers) observer.notifyAdd(item);
        return item;
    }

    public Item firstAddItem(String name, int count, int price, int id) {
        ItemProxy item = new ItemProxy(name, count, price, engine, id);
        items.add(item);
        for (Store.Observer observer : observers) observer.notifyAdd(item);
        return item;
    }
}
