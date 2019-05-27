package io.db;

import io.domain.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.domain.ItemAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class DatabaseTest {
    @Test
    public void testLoadStore() {
        DbEngine engine = mock(DbEngine.class);
        doAnswer(invocation -> {
            DbEngine.ItemListBuilder builder = invocation.getArgument(0);
            builder.add(101, "item1", 100, 1);
            builder.add(102, "item2", 200, 2);
            return null;
        }).when(engine).readItems(any(DbEngine.ItemListBuilder.class));
        List<Item> items = Database.loadStore(engine).items();
        assertThat(items).hasSize(2);
        assertThat(items.get(0)).hasData("item1", 100, 1);
        assertThat(items.get(1)).hasData("item2", 200, 2);
    }

    @Test
    public void testLoadAndUpdateItem() {
        DbEngine engine = mock(DbEngine.class);
        doAnswer(invocation -> {
            DbEngine.ItemListBuilder builder = invocation.getArgument(0);
            builder.add(101, "item1", 100, 1);
            return null;
        }).when(engine).readItems(any(DbEngine.ItemListBuilder.class));
        Item item = Database.loadStore(engine).items().get(0);
        item.update("item2", 200, 2);
        verify(engine).updateItem(101, "item2", 200, 2);
    }

    @Test
    public void testInsertAndUpdateItem() {
        DbEngine engine = mock(DbEngine.class);
        when(engine.insertItem("item1", 100, 1)).thenReturn(101);
        Item item = Database.loadStore(engine).addItem("item1", 100, 1);
        item.update("item2", 200, 2);
        verify(engine).updateItem(101, "item2", 200, 2);
    }
}