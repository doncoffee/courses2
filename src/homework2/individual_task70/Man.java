package homework2.individual_task70;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Man {

    private String name;
    private LocalDate dateOfBirth;
    private Boolean hasJob;

    public Man(String name, LocalDate dateOfBirth, Boolean hasJob) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.hasJob = hasJob;
    }

    public int calculateAge(LocalDate dateOfBirth) {
        LocalDate ld = LocalDate.now();
        Period period = Period.between(dateOfBirth, ld);
        return period.getYears();
    }

    public String reverseName(String name) {
        StringBuilder result = new StringBuilder(name);
        return result.reverse().toString();
    }

    public void printStatus() {
        if (hasJob) {
            System.out.println("Has a job");
        } else {
            System.out.println("Has no job");
        }
    }

    public static void analyzeClass(Object o) {
        Class clazz = o.getClass();
        System.out.println("Имя класса: " + clazz);
        System.out.println("Поля класса: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Методы класса: " +  Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Конструкторы класса: " + Arrays.toString(clazz.getConstructors()));
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getHasJob() {
        return hasJob;
    }

}
