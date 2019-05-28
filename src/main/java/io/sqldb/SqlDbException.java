package io.sqldb;

import java.sql.SQLException;

public class SqlDbException extends RuntimeException {
    public SqlDbException(SQLException cause) { super(cause); }
}
