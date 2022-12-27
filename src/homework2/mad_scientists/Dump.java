package homework2.mad_scientists;

import java.util.*;

public class Dump {

    private List<RobotParts> parts = RobotParts.generateRobotParts(20);
    private List<RobotParts> scientistsList1 = new ArrayList<>();
    private List<RobotParts> scientistsList2 = new ArrayList<>();

    private static final Random PRNG = new Random();

    // собирает от 1 до 4 случайных деталей для первого ученого
    public void collectParts1() {
        if (!parts.isEmpty()) {
            int randomlySelectedIndex = PRNG.nextInt(parts.size());
            RobotParts element = parts.get(randomlySelectedIndex);
            parts.remove(randomlySelectedIndex);
            scientistsList1.add(element);
        }
        System.out.println("First scientist's list " + scientistsList1);
    }

    // собирает от 1 до 4 случайных деталей для второго ученого
    public void collectParts2() {
        if (!parts.isEmpty()) {
            int randomlySelectedIndex = PRNG.nextInt(parts.size());
            RobotParts element = parts.get(randomlySelectedIndex);
            parts.remove(randomlySelectedIndex);
            scientistsList2.add(element);
        }
        System.out.println("Second scientist's list " + scientistsList2);
    }

    // выбрасывает на свалку от 1 до 4 случайных деталей
    public void produceParts() {
        int randomQuantity = PRNG.nextInt(1, 4);
        for (int i = 0; i < randomQuantity; i++) {
            parts.add(RobotParts.getRandomParts());
        }
        System.out.println("General list " + parts);
    }

    // считает роботов для победы ученых
    public int countRobots(List<RobotParts> scientistsList) {
        Map<RobotParts, Integer> map = new HashMap<>();
        scientistsList.removeAll(Collections.singletonList(null));
        for (RobotParts parts : scientistsList) {
            if (!map.containsKey(parts)) {
                map.put(parts, 1);
            } else {
                map.put(parts, map.get(parts) + 1);
            }
        }
//        System.out.println(map);
        if (map.size() < RobotParts.values().length) {        // если какой-либо части нет, то кол-во собранных роботов = 0
            return 0;
        }
        return Collections.min(map.values());                 // возвращает наименьшее кол-во собранных деталей
    }

    public List<RobotParts> getScientistsList1() {
        return scientistsList1;
    }

    public List<RobotParts> getScientistsList2() {
        return scientistsList2;
    }
}
