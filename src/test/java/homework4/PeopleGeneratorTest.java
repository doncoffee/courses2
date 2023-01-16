package homework4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeopleGeneratorTest {

    private PeopleGenerator peopleGenerator = new PeopleGenerator();

    @Test
    public void generatePeople() {
        assertEquals(10, peopleGenerator.generatePeople(10).size());
    }
}