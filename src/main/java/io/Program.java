package io;

import io.db.DbEngine;
import io.db.Database;
import io.swingui.SwingFacade;
import io.sqldb.SqlDbFactory;

public class Program {
    public static void main(String[] args) {
        DbEngine engine = new SqlDbFactory().engine();
        Database db = new Database(engine);
        SwingFacade.start(db.loadStore());
    }
}
