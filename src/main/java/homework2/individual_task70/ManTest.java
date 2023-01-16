package homework2.individual_task70;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;

class ManTest {
    private Man man = new Man("John", LocalDate.of(1980, 1, 8), true);

    @BeforeAll
    static void beforeAll() {
        System.out.println("Test init");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Test over");
    }

    @org.junit.jupiter.api.Test
    void calculateAge() {
        int actual = man.calculateAge(man.getDateOfBirth());
        Assertions.assertEquals(42, actual);
    }

}