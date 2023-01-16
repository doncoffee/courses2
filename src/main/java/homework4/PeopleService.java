package homework4;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PeopleService {

    public static final String PEOPLE_TXT = "people.txt";

    public List<People> filterAge(List<People> list, int age) {
        return list.stream().filter(e -> e.getAge() < age)
                .toList();
    }

    public List<People> sortPeople(List<People> list) {
        return list.stream().sorted(Comparator.comparing(People::getSurname)
                        .thenComparing(People::getName))
                .toList();
    }

    public List<People> getUniquePeople(List<People> list) {
        return list.stream().distinct()
                .toList();
    }

    public void writeIntoFile(List<People> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(PEOPLE_TXT)))) {
            for (People people : list) {
                oos.writeObject(people);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<People> readFromFile() {
        List<People> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(PEOPLE_TXT)))) {
            while (true) {
                try {
                    list.add((People) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
