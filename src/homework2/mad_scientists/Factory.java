package homework2.mad_scientists;

public class Factory implements Runnable {
    Dump dump;

    public Factory(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println(i + " factory night");
            dump.produceParts();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
