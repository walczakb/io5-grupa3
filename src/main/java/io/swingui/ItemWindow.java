package io.swingui;

import io.ui.ItemPresenter;
import io.ui.ItemView;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class ItemWindow extends JDialog implements ItemView {
    private JFormattedTextField nameField;
    private JFormattedTextField countField;
    private JFormattedTextField priceField;

    public void initialize(ItemPresenter presenter) {
        setBounds(150, 150, 300, 180);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        nameField = new JFormattedTextField();
        panel.add(nameField);
        countField = new JFormattedTextField();
        panel.add(countField);
        priceField = new JFormattedTextField();
        panel.add(priceField);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(e -> presenter.confirm());
        buttonPane.add(btnOk);
        getRootPane().setDefaultButton(btnOk);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> presenter.cancel());
        buttonPane.add(btnCancel);
    }

    public void open(String name, String count, String price) {
        nameField.setValue(name);
        countField.setValue(count);
        priceField.setValue(price);
        setVisible(true);
    }

    public String getName() { return (String)nameField.getValue(); }
    public String getCount() { return (String)countField.getValue(); }
    public String getPrice() { return (String)priceField.getValue(); }

    public void close() {
        setVisible(false);
        dispose();
    }
}
