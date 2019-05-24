package io.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    public interface Observer {
        void notifyAdd(Item item);
    }

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) { observers.add(observer); }
    public void removeObserver(Observer observer) { observers.remove(observer); }

    private List<Item> items = new ArrayList<>();

    public List<Item> items() { return Collections.unmodifiableList(items); }

    public void addItem(Item item) {
        items.add(item);
        for (Observer observer : observers) observer.notifyAdd(item);
    }
}
