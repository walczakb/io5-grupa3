package io.db;

import io.domain.Item;
import io.domain.Store;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoreProxyTest {
    @Test
    void testCreate(){
        DbEngine engine = mock(DbEngine.class);
        Store store = mock(Store.class);
        StoreProxy storeProxy = new StoreProxy(engine, store);
        assertThat(storeProxy.items()).isEmpty();
    }

    @Test
    void testAdd(){
        DbEngine engine = mock(DbEngine.class);
        ItemProxy.ids = mock(Map.class);
        Store store = new Store();
        StoreProxy storeProxy = new StoreProxy(engine, store);
        Item itemProxy1 = storeProxy.addItem("item1", 100, 1);
        Item itemProxy2 = storeProxy.addItem("item2", 200, 2);
        when(ItemProxy.ids.get(itemProxy1)).thenReturn(1);
        when(ItemProxy.ids.get(itemProxy2)).thenReturn(2);

        assertThat(storeProxy.items()).containsExactly(itemProxy1, itemProxy2);
        verify(engine).insertItem("item1", 100, 1);
        verify(engine).insertItem("item2", 200, 2);
    }

}