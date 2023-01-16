package homework4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleServiceTest {

    public static final int PEOPLE_QUANTITY = 100;
    public static final int AGE_LIMIT = 21;
    private PeopleGenerator peopleGenerator = new PeopleGenerator();
    private List<People> defList = peopleGenerator.generatePeople(PEOPLE_QUANTITY);
    private PeopleService service = new PeopleService();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests have begun");
    }

    @Test
    public void filterAge() {
        List<People> filteredList = service.filterAge(defList, AGE_LIMIT);
        for (People people : filteredList) {
            if (people.getAge() > AGE_LIMIT) {
                Assertions.fail();
            }
        }
    }

    @Test
    public void sortPeople() {
        List<People> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, new People("Bob", "Anderson", 20),
                new People("Megan", "Anderson", 20),
                new People("Arthur", "Harris", 17),
                new People("John", "Williams", 16));
        List<People> testList = new ArrayList<>();
        Collections.addAll(testList, new People("Arthur", "Harris", 17),
                new People("Bob", "Anderson", 20),
                new People("John", "Williams", 16),
                new People("Megan", "Anderson", 20));
        List<People> actualList = service.sortPeople(testList);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void getUniquePeople() {
        List<People> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, new People("Bob", "Anderson", 20),
                new People("Megan", "Anderson", 20),
                new People("Arthur", "Harris", 17));
        List<People> testList = new ArrayList<>();
        Collections.addAll(testList, new People("Bob", "Anderson", 20),
                new People("Megan", "Anderson", 20),
                new People("Megan", "Anderson", 20),
                new People("Arthur", "Harris", 17),
                new People("Arthur", "Harris", 17));
        List<People> actualList = service.getUniquePeople(testList);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void readFromFile() {
        List<String> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, "Bob Anderson", "Megan Anderson",
                "Arthur Harris");
        List<People> testList = new ArrayList<>();
        Collections.addAll(testList, new People("Bob", "Anderson", 20),
                new People("Megan", "Anderson", 20),
                new People("Arthur", "Harris", 17));
        service.writeIntoFile(testList);
        List<String> actualList = service.readFromFile().stream()
                .map(e -> e.getName() + " " + e.getSurname())
                .toList();
        Assertions.assertEquals(expectedList, actualList);
    }
}