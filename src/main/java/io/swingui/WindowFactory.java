package io.swingui;

import io.domain.Item;
import io.domain.Store;
import io.ui.ItemPresenter;
import io.ui.StorePresenter;
import io.ui.ViewFactory;

public class WindowFactory implements ViewFactory {

    public void openEditItemView(Item item) {
        ItemWindow view = new ItemWindow();
        ItemPresenter presenter = new ItemPresenter(view);
        view.initialize(presenter);
        presenter.initializeEdit(item);
    }

    public void openAddItemView(Store store) {
        ItemWindow view = new ItemWindow();
        ItemPresenter presenter = new ItemPresenter(view);
        view.initialize(presenter);
        presenter.initializeAdd(store);
    }

    public void openStoreView(Store store) {
        StoreWindow view = new StoreWindow();
        StorePresenter presenter = new StorePresenter(store, view, this);
        view.initialize(presenter);
        presenter.initialize();
    }
}
