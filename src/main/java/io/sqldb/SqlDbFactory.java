package io.sqldb;

public class SqlDbFactory {
    private final String host = "db.tcs.uj.edu.pl";
    private final String port = "5432";
    private final String database = "";
    private final String user = "";
    private final String password = "";

    public SqlDbEngine engine() {
        return new SqlDbEngine(
                "jdbc:postgresql://" + host + ":" + port + "/" + database,
                user, password);
    }
}
