package homework2.mad_scientists;

public class Runner {

    public static void main(String[] args) {
        Dump dump = new Dump();
        MadScientist1 scientist1 = new MadScientist1(dump);
        MadScientist2 scientist2 = new MadScientist2(dump);
        Factory factory = new Factory(dump);
        Thread th1 = new Thread(scientist1);
        Thread th2 = new Thread(scientist2);
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
        System.out.println("Quantity of robot parts collected by first scientist " + dump.countRobots(dump.getScientistsList1()));
        System.out.println("Quantity of robot parts collected by second scientist " + dump.countRobots(dump.getScientistsList2()));
        if (dump.countRobots(dump.getScientistsList1()) > dump.countRobots(dump.getScientistsList2())) {
            System.out.println("First mad scientist wins!\nHe collected " + dump.countRobots(dump.getScientistsList1()) + " robots.");
        } else if (dump.countRobots(dump.getScientistsList1()) < dump.countRobots(dump.getScientistsList2())) {
            System.out.println("Second mad scientist wins!\nHe collected " + dump.countRobots(dump.getScientistsList2()) + " robots.");
        } else {
            System.out.println("It's a tie!\nThey both collected " + dump.countRobots(dump.getScientistsList1()) + " robots.");
        }
    }
}
