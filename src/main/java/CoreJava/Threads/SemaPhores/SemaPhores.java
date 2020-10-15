package CoreJava.Threads.SemaPhores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * Used to restrict the access.
 * Lets say you have 10 threads you want only 2 threads at a time
 * want to access certain system, we use semaphores.
 */
public class SemaPhores {
    public static void main(String[] args) {
        final ExecutorService executors = Executors.newFixedThreadPool(50);
        final Semaphore semaphore = new Semaphore(2);
        IntStream.range(0, 50).forEach(value -> {
            executors.execute(new Task(semaphore, value));
        });
    }
}

class Task implements Runnable {
    final Semaphore semaphore;
    final int taskNo;

    public Task(final Semaphore semaphore, final int taskNo) {
        this.semaphore = semaphore;
        this.taskNo = taskNo;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Trying to acquire the semaphore for task " + taskNo);
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " acquired the semaphore for task " + taskNo);
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " Done processing, releasing semaphore for for task " + taskNo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " released semaphore successfully for task " + taskNo);
        }
    }
}
