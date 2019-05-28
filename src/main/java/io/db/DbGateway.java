package io.db;

import io.domain.Item;
import io.domain.Store;

public interface DbGateway {
    Store loadStore();
}
