package homework2.mad_scientists;

import java.util.*;

public class Dump {

    public static final int UPPER_BOUND = 4;
    public static final int LOWER_BOUND = 1;
    private volatile List<RobotParts> parts = RobotParts.generateRobotParts(20);
    private static final Random PRNG = new Random();

    // выбрасывает на свалку от 1 до 4 случайных деталей
    public void produceParts() {
        for (int i = 0; i < PRNG.nextInt(UPPER_BOUND) + LOWER_BOUND; i++) {
            parts.add(RobotParts.getRandomParts());
        }
        System.out.println("General list " + parts);
    }

    // считает роботов для победы ученых
    public int countRobots(List<RobotParts> scientistsList) {
        Map<RobotParts, Integer> map = new HashMap<>();
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

    public List<RobotParts> getParts() {
        return parts;
    }
}
