package io.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class StoreTest {
    @Test
    public void testCreate() {
        Store store = new Store();
        assertThat(store.items()).isEmpty();
    }

    @Test
    public void testAdd() {
//        Item item1 = new Item("item1", 100, 1);
//        Item item2 = new Item("item2", 200, 2);
//        Store store = new Store();
//        store.addItem(item1);
//        store.addItem(item2);
//        assertThat(store.items()).containsExactly(item1, item2);
    }

    @Test
    public void testObserver() {
//        Store store = new Store();
//        Store.Observer observer = mock(Store.Observer.class);
//        store.addObserver(observer);
//        Item item1 = new Item("item1", 100, 1);
//        store.addItem(item1);
//        store.removeObserver(observer);
//        store.addItem(new Item("item2", 200, 2));
//        verify(observer, times(1)).notifyAdd(item1);
//        verifyNoMoreInteractions(observer);
    }
}
