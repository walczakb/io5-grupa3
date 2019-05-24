package io.ui;

public interface ItemView {
    void open(String name, String count, String price);
    String getName();
    String getCount();
    String getPrice();
    void close();
}
