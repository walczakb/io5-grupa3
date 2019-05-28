package io.ui;

import io.db.DbGateway;
import io.domain.Item;
import io.domain.Store;
import org.junit.jupiter.api.Test;

import static io.domain.ItemAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ItemPresenterTest {
    @Test
    public void testInitializeEdit() {
        Item item = new Item("item", 100, 1);
        ItemView view = mock(ItemView.class);
        ItemPresenter presenter = new ItemPresenter(view);
        presenter.initializeEdit(item);
        verify(view).open("item", "100", "1");
    }

    @Test
    public void testInitializeAdd() {
        ItemView view = mock(ItemView.class);
        ItemPresenter presenter = new ItemPresenter(view);
        presenter.initializeAdd(null);
        verify(view).open("", "", "");
    }

    @Test
    public void testConfirmEdit() {
        Item item = new Item("item1", 100, 1);
        ItemView view = mock(ItemView.class);
        when(view.getName()).thenReturn("item2");
        when(view.getCount()).thenReturn("200");
        when(view.getPrice()).thenReturn("2");
        ItemPresenter presenter = new ItemPresenter(view);
        presenter.initializeEdit(item);
        presenter.confirm();
        assertThat(item).hasData("item2", 200, 2);
    }

    @Test
    public void testConfirmAdd() {
        ItemView view = mock(ItemView.class);
        when(view.getName()).thenReturn("item");
        when(view.getCount()).thenReturn("100");
        when(view.getPrice()).thenReturn("1");
        ItemPresenter presenter = new ItemPresenter(view);
        Store store = new Store();
        presenter.initializeAdd(store);
        presenter.confirm();
        assertThat(store.items()).hasSize(1);
        Item item = store.items().get(0);
        assertThat(item).hasData("item", 100, 1);
    }

    @Test
    public void testCancel() {
        ItemView view = mock(ItemView.class);
        ItemPresenter presenter = new ItemPresenter(view);
        presenter.cancel();
        verify(view).close();
    }
}