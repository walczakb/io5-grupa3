package io.ui;

import io.domain.Item;
import io.domain.Store;

public interface ViewFactory {
    void openEditItemView(Item item);
    void openAddItemView(Store store);
    void openStoreView(Store store);
}
