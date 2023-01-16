package homework2.mad_scientists;

public class Runner {

    public static void main(String[] args) {
        Dump dump = new Dump();
        MadScientist scientist1 = new MadScientist(dump);
        MadScientist scientist2 = new MadScientist(dump);
        Factory factory = new Factory(dump);
        Thread th1 = new Thread(scientist1, "first scientist");
        Thread th2 = new Thread(scientist2, "second scientist");
        Thread th3 = new Thread(factory);
        th1.start();
        th2.start();
        th3.start();
        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Quantity of robot parts collected by first scientist "
                + dump.countRobots(scientist1.getScientistsList()));
        System.out.println("Quantity of robot parts collected by second scientist "
                + dump.countRobots(scientist2.getScientistsList()));
        if (dump.countRobots(scientist1.getScientistsList())
                > dump.countRobots(scientist2.getScientistsList())) {
            System.out.println("First mad scientist wins!\nHe collected "
                    + dump.countRobots(scientist1.getScientistsList()) + " robots.");
        } else if (dump.countRobots(scientist1.getScientistsList())
                < dump.countRobots(scientist2.getScientistsList())) {
            System.out.println("Second mad scientist wins!\nHe collected "
                    + dump.countRobots(scientist2.getScientistsList()) + " robots.");
        } else {
            System.out.println("It's a tie!\nThey both collected "
                    + dump.countRobots(scientist1.getScientistsList()) + " robots.");
        }
    }
}
