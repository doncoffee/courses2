package homework5;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonImpl extends Util implements DAOPerson {
    public static final String TABLE_NAME = Person.class.getDeclaredAnnotation(MyTable.class).name();
    public static final Field[] FIELDS = Person.class.getDeclaredFields();
    public static final String FIRST_FIELD = FIELDS[0].getName();
    public static final String SECOND_FIELD = FIELDS[1].getName();
    public static final String THIRD_FIELD = FIELDS[2].getName();
    private Connection connection = getConnection();
    @Override
    public void insert(Person person) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO " + TABLE_NAME + " (" + FIRST_FIELD
                + ", " + SECOND_FIELD + ", " + THIRD_FIELD
                + ") VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getSurname());

            preparedStatement.executeLargeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Person> select() throws SQLException {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT " + FIRST_FIELD + ", "
                + SECOND_FIELD + ", " + THIRD_FIELD
                +" FROM " + TABLE_NAME;

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                personList.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return personList;
    }

    @Override
    public void update(Person person) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE " + TABLE_NAME +  " SET " + FIRST_FIELD
                + "=?, " + SECOND_FIELD +"=?, " + THIRD_FIELD
                + "=? WHERE " + FIRST_FIELD + "=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getSurname());
            preparedStatement.setInt(4, person.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Person person) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + FIRST_FIELD + "=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, person.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
