package homework2.mad_scientists;

public class Factory implements Runnable {
    public static final int MILLIS = 100;
    public static final int NIGHTS = 100;
    private final Dump dump;

    public Factory(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 1; i <= NIGHTS; i++) {
            System.out.println(i + " factory night");
            dump.produceParts();
            try {
                Thread.sleep(MILLIS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
