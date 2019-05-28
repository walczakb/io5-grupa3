package io.sqldb;

import io.db.DbEngine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SqlDbEngine implements DbEngine {
    private final String url;
    private final String user;
    private final String password;

    public SqlDbEngine(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void readItems(ItemListBuilder builder) {
        try (Connection connection = getConnection();
             PreparedStatement sql = connection.prepareStatement(
                     "SELECT * FROM io_items");
             ResultSet rs = sql.executeQuery()) {
            while (rs.next()) builder.add(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("count"),
                    rs.getInt("price"));
        }
        catch (SQLException ex) { throw new SqlDbException(ex); }
    }

    public int insertItem(String name, int count, int price) {
        try (Connection connection = getConnection();
             PreparedStatement sql = connection.prepareStatement(
                     "INSERT INTO io_items (name, count, price) VALUES (?, ?, ?) RETURNING id")) {
            sql.setString(1, name);
            sql.setInt(2, count);
            sql.setInt(3, price);
            try (ResultSet rs = sql.executeQuery()) {
                rs.next();
                return rs.getInt("id");
            }
        }
        catch (SQLException ex) { throw new SqlDbException(ex); }
    }

    public void updateItem(int id, String name, int count, int price) {
        try (Connection connection = getConnection();
             PreparedStatement sql = connection.prepareStatement(
                     "UPDATE io_items SET (name, count, price) = (?, ?, ?) WHERE id = ?")) {
            sql.setString(1, name);
            sql.setInt(2, count);
            sql.setInt(3, price);
            sql.setInt(4, id);
            sql.executeUpdate();
        }
        catch (SQLException ex) { throw new SqlDbException(ex); }
    }
}
