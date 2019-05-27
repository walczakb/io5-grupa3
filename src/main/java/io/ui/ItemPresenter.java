package io.ui;

import io.db.DbGateway;
import io.domain.Item;
import io.domain.Store;

public class ItemPresenter {
    private interface ConfirmAction {
        void perform(String name, int count, int price);
    }

    private final ItemView view;
    private ConfirmAction confirmAction;

    public ItemPresenter(ItemView view) { this.view = view; }

    public void initializeEdit(Item item, DbGateway db) {
        confirmAction = (name, count, price) -> {
            item.update(name, count, price);
            db.updateItem(item);
        };
        view.open(item.name(),
                String.valueOf(item.count()),
                String.valueOf(item.price()));
    }

    public void initializeAdd(Store store, DbGateway db) {
        confirmAction = (name, count, price) -> {
            Item item = store.addItem(name, count, price);
            db.addItem(item);
        };
        view.open("", "", "");
    }

    public void confirm() {
        confirmAction.perform(view.getName(),
                Integer.parseInt(view.getCount()),
                Integer.parseInt(view.getPrice()));
        view.close();
    }

    public void cancel() { view.close(); }
}
