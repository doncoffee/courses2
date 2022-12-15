package homework2.individual_task72;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<RandomClass> randomClass = RandomClass.class;
        Method method1 = randomClass.getMethod("getRandomYear");
        Annotation[] annotations1 = method1.getAnnotations();

        System.out.println("\nПоиск аннотаций в " + annotations1.getClass().getName());
        for (Annotation annotation : annotations1) {
            if (annotation instanceof AcademyInfo year) {
                System.out.println("Год: " + year.year());
            }
        }

        Method method2 = randomClass.getMethod("getCurrentYear");
        Annotation[] annotations2 = method2.getAnnotations();
        System.out.println("\nПоиск аннотаций в " + annotations2.getClass().getName());
        for (Annotation annotation : annotations2) {
            if (annotation instanceof AcademyInfo year) {
                System.out.println("Год: " + year.year());
            }
        }

    }
}
