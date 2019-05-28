package io.db;

import io.domain.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class StoreProxyTest {
    @Test
    public void testCreateItem() {
        DbEngine engine = mock(DbEngine.class);
        when(engine.insertItem("item1", 100, 1)).thenReturn(1);

        StoreProxy store = new StoreProxy(null, engine);

        Item item = store.createItem("item1", 100, 1);

        assertThat(item.name()).isEqualTo("item1");
        assertThat(item.count()).isEqualTo(100);
        assertThat(item.price()).isEqualTo(1);

        verify(engine).insertItem("item1", 100, 1);
    }
}
