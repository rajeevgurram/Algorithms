import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    static ExecutorService executorService = Executors.newFixedThreadPool(1000);

    public static void main(String[] args) {
        for(int i = 0; i < 1000000; i ++) {
            executorService.submit(new Task(String.valueOf(i)));
        }
        System.out.println("Finished Submitting Work");
    }
}

class Task implements Runnable {
    final String task;

    public Task(final String task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Starting " + task);
            Thread.sleep(1);
            System.out.println(Thread.currentThread().getName() + " Finished " + task);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
