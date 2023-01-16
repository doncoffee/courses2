package homework2.individual_task72;

import java.time.LocalDate;
import java.util.Random;

public class RandomClass {

    public int getRandomYear() {
        return new Random().nextInt(0, LocalDate.now().getYear());
    }

    @AcademyInfo(year = 2022)
    public int getCurrentYear() {
        return LocalDate.now().getYear();
    }
}
