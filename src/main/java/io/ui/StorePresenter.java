package io.ui;

import io.domain.Item;
import io.domain.Store;

public class StorePresenter {
    private final Store store;
    private final StoreView view;
    private final ViewFactory factory;

    private static String itemDescription(Item item) {
        return item.name() + ": " + item.count() + " at $" + item.price();
    }

    private Item.Observer itemObserver = new Item.Observer() {
        public void notifyUpdate(Item item) {
            view.setItem(store.items().indexOf(item), itemDescription(item));
        }
    };
    private Store.Observer storeObserver = new Store.Observer() {
        public void notifyAdd(Item item) {
            view.addItem(itemDescription(item));
            item.addObserver(itemObserver);
        }
    };

    public StorePresenter(Store store, StoreView view, ViewFactory factory) {
        this.store = store;
        this.view = view;
        this.factory = factory;
    }

    public void initialize() {
        for (Item item : store.items()) view.addItem(itemDescription(item));
        view.open();
        for (Item item : store.items()) item.addObserver(itemObserver);
        store.addObserver(storeObserver);
    }

    public void editItem(int index) {
        factory.openEditItemView(store.items().get(index));
    }

    public void addItem() {
        factory.openAddItemView(store);
    }

    public void close() {
        store.removeObserver(storeObserver);
        for (Item item : store.items()) item.removeObserver(itemObserver);
        view.close();
    }
}
