package homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PeopleGenerator {

    public static final int MAX_AGE_BOUND = 30;
    public static final int MIN_AGE_BOUND = 15;
    private final String[] names = {"John", "Bella", "Carl", "Bill", "Oliver",
            "Mark", "Arnold", "Frank", "Victoria", "Cloe"};
    private final String[] surnames = {"Smith", "Williams", "Johns", "Thomas",
            "Evans", "Davies", "Brown", "Taylor", "Harris", "Roberts"};

    public List<People> generatePeople(int quantity) {
        List<People> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            String randomName = names[new Random().nextInt(names.length)];
            String randomSurName = surnames[new Random().nextInt(surnames.length)];
            int randomAge = new Random().nextInt(MAX_AGE_BOUND - MIN_AGE_BOUND + 1) + MIN_AGE_BOUND;
            list.add(new People(randomName, randomSurName, randomAge));
        }
        return list;
    }
}
