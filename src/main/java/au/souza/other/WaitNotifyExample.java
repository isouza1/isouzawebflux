package au.souza.other;

public class WaitNotifyExample {
    private Object lock = new Object();
    private int item = -1;
    private boolean isItemAvailable = false;

    public void produce(int value) throws InterruptedException {
        synchronized (lock) {
            // Wait while item is being consumed
            while (isItemAvailable) {
                lock.wait();
            }

            // Producing item
            item = value;
            System.out.println("Produced: " + item);
            isItemAvailable = true;

            // Notify the consumer that item is available
            lock.notify();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            // Wait until an item is available
            while (!isItemAvailable) {
                lock.wait();
            }

            // Consuming item
            System.out.println("Consumed: " + item);
            isItemAvailable = false;

            // Notify the producer that item has been consumed
            lock.notify();
        }
    }

    public static void main(String[] args) {
        WaitNotifyExample example = new WaitNotifyExample();

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    example.produce(i);
                    Thread.sleep(100); // Simulate some delay
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    example.consume();
                    Thread.sleep(150); // Simulate some delay
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
