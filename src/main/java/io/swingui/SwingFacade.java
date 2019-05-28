package io.swingui;

import io.db.DbGateway;
import io.domain.Store;

import javax.swing.SwingUtilities;

public class SwingFacade {
    public static void start(Store store) {
        SwingUtilities.invokeLater(() -> new WindowFactory().openStoreView(store));
    }
}
