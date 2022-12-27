package homework2.mad_scientists;

public class MadScientist1 implements Runnable {
    Dump dump;
    public MadScientist1(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) { // 100 ночей
            System.out.println(i + " first madScientist night");
            dump.collectParts1();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
