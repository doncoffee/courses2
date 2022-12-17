package homework2.mad_scientists;

public class MadScientist1 implements Runnable {
    Dump dump;
    public MadScientist1(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) { // 100 ночей
            dump.collectParts1();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
