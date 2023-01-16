package homework5;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {
        DAO<Person> daoPerson1 = new DAOPersonImpl();
        daoPerson1.delete(new Person(1, "Elizabeth", "Turner"));
//        daoPerson1.insert(new Person(11, "Peter", "Griffin"));
//        будет ошибка: No operations allowed after connection closed.
        DAO<Person> daoPerson2 = new DAOPersonImpl();
        daoPerson2.insert(new Person(10, "Peter", "Griffin"));
        DAO<Person> daoPerson3 = new DAOPersonImpl();
        daoPerson3.update(new Person(3, "Greg", "Davidson"));
        DAO<Person> daoPerson4 = new DAOPersonImpl();
        List<Person> personList = daoPerson4.select();
        for (Person persons : personList) {
            System.out.println(persons);
        }
    }
}
