package homework2.mad_scientists;

public class MadScientist2 implements Runnable {
    Dump dump;
    public MadScientist2(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println(i + " second madScientist night");
            dump.collectParts2();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
