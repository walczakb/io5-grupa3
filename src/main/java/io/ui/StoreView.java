package io.ui;

public interface StoreView {
    void open();
    void setItem(int index, String item);
    void addItem(String item);
    void close();
}
