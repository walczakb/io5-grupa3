package io.swingui;

import io.db.DbGateway;
import io.domain.Store;

import javax.swing.SwingUtilities;

public class SwingFacade {
    public static void start(Store store, DbGateway db) {
        SwingUtilities.invokeLater(() -> new WindowFactory(db).openStoreView(store));
    }
}
