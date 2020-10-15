package DataStructures.BlockingQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new ArrayBlockingQueueSynchronized<>();

        Thread producerThread = new Thread(new Producer(queue, 30));
        Thread consumerThread = new Thread(new Consumer(queue, 2000));

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int waitTime;
    public Producer(final BlockingQueue<Integer> queue, final int waitTime) {
        this.queue = queue;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        try {
            int number = 0;
            while (true) {
                Thread.sleep(waitTime);
                number = number+1;
                queue.put(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int waitTime;
    public Consumer(final BlockingQueue<Integer> queue, final int waitTime) {
        this.queue = queue;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(waitTime);
                int number = queue.take();
                System.out.println("consumed " + number + ", thread: " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
