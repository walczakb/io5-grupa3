package io.swingui;

import io.domain.Store;

import javax.swing.*;

public class SwingFacade {
    public static void start(Store store) {
        SwingUtilities.invokeLater(() -> new WindowFactory().openStoreView(store));
    }
}
