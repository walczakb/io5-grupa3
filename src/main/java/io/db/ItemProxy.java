package io.db;

import io.domain.Item;

import java.util.ArrayList;
import java.util.List;

class ItemProxy extends Item {

    public ItemProxy(String name, int count, int price, DbEngine engine, int id) {
        super(name, count, price);
        this.name = name;
        this.count = count;
        this.price = price;
        this.engine = engine;
        this.id = id;
    }

    private List<Item.Observer> observers = new ArrayList<>();

    public void addObserver(Item.Observer observer) { observers.add(observer); }
    public void removeObserver(Item.Observer observer) { observers.remove(observer); }

    private String name;
    private int count;
    private int price;

    private int id;

    private DbEngine engine;

    public String name() { return name; }
    public int count() { return count; }
    public int price() { return price; }

    public void update(String name, int count, int price) {
        engine.updateItem(id, name, count, price);
        this.name = name;
        this.count = count;
        this.price = price;
        for (Item.Observer observer : observers) observer.notifyUpdate(this);
    }
}
