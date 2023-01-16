package homework5;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    void insert(T t) throws SQLException;
    List<T> select() throws SQLException;
    void update (T t) throws SQLException;
    void delete(T t) throws SQLException;
}
