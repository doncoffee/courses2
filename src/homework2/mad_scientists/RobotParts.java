package homework2.mad_scientists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum RobotParts {
    HEAD,
    BODY,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    // дает случайную деталь
    public static RobotParts getRandomParts()  {
        RobotParts[] parts = values();
        return parts[new Random().nextInt(parts.length)];
    }

    // задает первичный лист из 20 случайных деталей
    public static List<RobotParts> generateRobotParts(int quantity) {
        List<RobotParts> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            list.add(RobotParts.getRandomParts());
        }
        return list;
    }

}
