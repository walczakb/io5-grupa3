package io.domain;

import java.util.ArrayList;
import java.util.List;

public class Item {
    public interface Observer {
        void notifyUpdate(Item item);
    }

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) { observers.add(observer); }
    public void removeObserver(Observer observer) { observers.remove(observer); }

    private String name;
    private int count;
    private int price;

    public Item(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public String name() { return name; }
    public int count() { return count; }
    public int price() { return price; }

    public void update(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
        for (Observer observer : observers) observer.notifyUpdate(this);
    }
}
