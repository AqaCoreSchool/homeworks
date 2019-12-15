package database.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetHandler {
    void handle(ResultSet handler) throws SQLException;
}