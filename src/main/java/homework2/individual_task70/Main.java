package homework2.individual_task70;

import java.lang.reflect.Method;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {
        Man man = new Man("John", LocalDate.of(1980, 1, 8), true);
        Method getManMethod = man.getClass().getMethod("analyzeClass", Object.class);
        Object resultValue = getManMethod.invoke("analyzeClass", man);
//        man.analyzeClass(man);
    }
}
