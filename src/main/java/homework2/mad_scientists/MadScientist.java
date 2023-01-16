package homework2.mad_scientists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class MadScientist implements Runnable {

    public static final int NIGHTS = 100;
    public static final int MILLIS = 100;
    private static final Random PRNG = new Random();
    public static final int UPPER_BOUND = 4;
    public static final int LOWER_BOUND = 1;
    private List<RobotParts> scientistsList = new CopyOnWriteArrayList<>();
    private final Dump dump;

    public MadScientist(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 1; i <= NIGHTS; i++) {
            System.out.println(i + " " + Thread.currentThread().getName() + " night");
            collectParts();
            try {
                Thread.sleep(MILLIS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // собирает от 1 до 4 случайных деталей
    public void collectParts() {
        for (int i = 0; i < PRNG.nextInt(UPPER_BOUND) + LOWER_BOUND; i++) {
            if (!dump.getParts().isEmpty()) {
                int randomlySelectedIndex = PRNG.nextInt(dump.getParts().size());
                if (randomlySelectedIndex < dump.getParts().size()) {
                    RobotParts element = dump.getParts().remove(randomlySelectedIndex);
                    scientistsList.add(element);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " list " + scientistsList);
    }

    public List<RobotParts> getScientistsList() {
        return scientistsList;
    }
}
