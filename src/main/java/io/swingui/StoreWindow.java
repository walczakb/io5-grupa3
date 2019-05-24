package io.swingui;

import io.ui.StorePresenter;
import io.ui.StoreView;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class StoreWindow extends JDialog implements StoreView {
    private DefaultListModel<String> model;
    private JList<String> list;

    public void initialize(StorePresenter presenter) {
        setBounds(100, 100, 450, 300);

        model = new DefaultListModel<>();
        list = new JList<>(model);
        getContentPane().add(list, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);

        JButton btnEditItem = new JButton("Edit item");
        btnEditItem.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index != -1) presenter.editItem(index);
        });
        panel.add(btnEditItem);

        JButton btnAddItem = new JButton("Add item");
        btnAddItem.addActionListener(e -> presenter.addItem());
        panel.add(btnAddItem);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> presenter.close());
        panel.add(btnClose);

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    public void open() { setVisible(true); }

    public void setItem(int index, String item) { model.set(index, item); }
    public void addItem(String item) { model.addElement(item); }

    public void close() {
        setVisible(false);
        dispose();
    }
}
