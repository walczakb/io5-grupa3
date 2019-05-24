package io.db;

public interface DbEngine {
    interface ItemListBuilder {
        void add(int id, String name, int count, int price);
    }

    void readItems(ItemListBuilder builder);
    int insertItem(String name, int count, int price);
    void updateItem(int id, String name, int count, int price);
}
