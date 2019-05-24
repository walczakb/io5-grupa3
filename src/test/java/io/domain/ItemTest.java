package io.domain;

import org.junit.jupiter.api.Test;

import static io.domain.ItemAssert.assertThat;
import static org.mockito.Mockito.*;

public class ItemTest {
    @Test
    public void testCreate() {
        Item item = new Item("item1", 100, 1);
        assertThat(item).hasData("item1", 100, 1);
    }

    @Test
    public void testUpdate() {
        Item item = new Item("item1", 100, 1);
        item.update("item2", 200, 2);
        assertThat(item).hasData("item2", 200, 2);
    }

    @Test
    public void testObserver() {
        Item item = new Item("item1", 100, 1);
        Item.Observer observer = mock(Item.Observer.class);
        item.addObserver(observer);
        item.update("item2", 200, 2);
        item.removeObserver(observer);
        item.update("item3", 300, 3);
        verify(observer, times(1)).notifyUpdate(item);
        verifyNoMoreInteractions(observer);
    }
}
