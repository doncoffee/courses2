package homework4;

import java.util.List;

public class Runner {

    public static final int AGE_LIMIT = 21;
    public static final int PEOPLE_QUANTITY = 100;

    public static void main(String[] args) {
        PeopleGenerator peopleGenerator = new PeopleGenerator();
        List<People> defList = peopleGenerator.generatePeople(PEOPLE_QUANTITY);
        PeopleService service = new PeopleService();
        // 1)
        List<People> filteredList = service.filterAge(defList, AGE_LIMIT);
        // 2)
        System.out.println(filteredList);
        // 3)
        List<People> sortedList = service.sortPeople(filteredList);
        // 4)
        List<People> uniquePeopleList = service.getUniquePeople(sortedList);
        // 5)
        service.writeIntoFile(uniquePeopleList);
        // 6) and 7)
        List<String> listFromFile = service.readFromFile().stream()
                .map(e -> e.getName() + " " + e.getSurname())
                .toList();
        // 8)
        System.out.println(listFromFile);
    }
}
