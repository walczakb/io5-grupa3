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
        Database db = new Database(engine);
        List<Item> items = db.loadStore().items();
        assertThat(items).hasSize(2);
        assertThat(items.get(0)).hasData("item1", 100, 1);
        assertThat(items.get(1)).hasData("item2", 200, 2);
    }
}