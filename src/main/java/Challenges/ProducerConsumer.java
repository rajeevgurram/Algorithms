package Challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
    //private List<Integer> data = Collections.synchronizedList(new ArrayList<>());
    private List<Integer> data = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(producerConsumer::startProducer);
        executorService.submit(producerConsumer::startProducer);
        executorService.submit(producerConsumer::startProducer);
        executorService.submit(producerConsumer::startProducer);
        executorService.submit(producerConsumer::startProducer);
        executorService.submit(producerConsumer::startConsumer);
    }

    int index = 0;
    int max_capacity = 1000;
    public void startProducer() {
        synchronized (this) {
            while (true) {
                data.add(index++);

                if(data.size() >= max_capacity) {
                    try {
                        wait();
                        System.out.println("After wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    notifyAll();
                }
            }
        }
    }

    public void startConsumer() {
        synchronized (this) {
            int total = 0;
            while (true) {
                if (data.size() > 0) {
                    total++;
                    Integer num = data.remove(0);
                    notifyAll();
                    System.out.println("Deleted " + num);
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


