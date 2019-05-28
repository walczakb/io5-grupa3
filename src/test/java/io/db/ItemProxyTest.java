package io.db;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.domain.ItemAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemProxyTest {
    @Test
    void testCreate(){
        DbEngine engine = mock(DbEngine.class);
        ItemProxy itemProxy = new ItemProxy(engine, "item1", 2, 1);
        assertThat(itemProxy).hasData("item1", 2, 1);
    }

    @Test
    void testUpdate(){
        DbEngine engine = mock(DbEngine.class);
        ItemProxy.ids = mock(Map.class);
        ItemProxy itemProxy = new ItemProxy(engine, "item1", 2, 1);
        when(ItemProxy.ids.get(itemProxy)).thenReturn(1);
        itemProxy.update("item2", 3, 4);
        assertThat(itemProxy).hasData("item2", 3, 4);
        verify(engine).updateItem(1, "item2", 3, 4);
    }
}