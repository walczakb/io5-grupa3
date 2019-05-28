package io.db;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ItemProxyTest {
    @Test
    public void testUpdate () {
        DbEngine engine = mock(DbEngine.class);

        ItemProxy item = new ItemProxy("item1", 100, 1, 1, engine);

        item.update("item2", 200, 2);

        assertThat(item.name()).isEqualTo("item2");
        assertThat(item.count()).isEqualTo(200);
        assertThat(item.price()).isEqualTo(2);

        verify(engine).updateItem(1, "item2", 200, 2);
    }
}
