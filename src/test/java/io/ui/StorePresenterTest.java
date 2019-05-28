package io.ui;

import io.domain.Item;
import io.domain.Store;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class StorePresenterTest {
    @Test
    public void testInitialize() {
        Store store = new Store();
        store.addItem("item1", 100, 1);
        store.addItem("item2", 200, 2);
        StoreView view = mock(StoreView.class);
        StorePresenter presenter = new StorePresenter(store, view, null);
        presenter.initialize();
        verify(view).addItem("item1: 100 at $1");
        verify(view).addItem("item2: 200 at $2");
        verify(view).open();
    }

    @Test
    public void testEditItem() {
        Store store = new Store();
        store.addItem("item1", 100, 1);
        Item item2 = store.addItem("item2", 200, 2);
        StoreView view = mock(StoreView.class);
        ViewFactory factory = mock(ViewFactory.class);
        StorePresenter presenter = new StorePresenter(store, view, factory);
        presenter.initialize();
        presenter.editItem(1);
        verify(factory).openEditItemView(item2);
    }

    @Test
    public void testAddItem() {
        Store store = new Store();
        StoreView view = mock(StoreView.class);
        ViewFactory factory = mock(ViewFactory.class);
        StorePresenter presenter = new StorePresenter(store, view, factory);
        presenter.initialize();
        presenter.addItem();
        verify(factory).openAddItemView(store);
    }

    @Test
    public void testClose() {
        Store store = new Store();
        StoreView view = mock(StoreView.class);
        StorePresenter presenter = new StorePresenter(store, view, null);
        presenter.close();
        verify(view).close();
    }

    @Test
    public void testItemObserver() {
        Store store = new Store();
        Item item = store.addItem("item1", 100, 1);
        StoreView view = mock(StoreView.class);
        StorePresenter presenter = new StorePresenter(store, view, null);
        presenter.initialize();
        item.update("item2", 200, 2);
        presenter.close();
        item.update("item3", 300, 3);
        verify(view).setItem(0, "item2: 200 at $2");
        verify(view, never()).setItem(0, "item3: 300 at $3");
    }

    @Test
    public void testStoreObserver() {
        Store store = new Store();
        StoreView view = mock(StoreView.class);
        StorePresenter presenter = new StorePresenter(store, view, null);
        presenter.initialize();
        Item item = store.addItem("item1", 100, 1);
        item.update("item2", 200, 2);
        presenter.close();
        store.addItem("item3", 300, 3);
        verify(view).addItem("item1: 100 at $1");
        verify(view).setItem(0, "item2: 200 at $2");
        verify(view, never()).addItem("item3: 300 at $3");
    }
}
