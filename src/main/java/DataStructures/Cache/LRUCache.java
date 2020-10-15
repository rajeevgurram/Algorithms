package DataStructures.Cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * LRU Cache Implementation.
 * Requirement:
 *  1.) Should have fixed size capacity
 *  2.) Should be able to add items,
 *      if size is full remove least used item
 *  3.) Should be able to retrieve items
 */
public class LRUCache implements Runnable {
    class Node {
        int data;
        long ttl;
        long originalTtl;
        public Node(int data, long ttl) {
            this.data = data;
            this.originalTtl = ttl;
            this.ttl = System.currentTimeMillis() / 1000 + originalTtl;
        }

        public void setNewTTL() {
            this.ttl = System.currentTimeMillis() / 1000 + originalTtl;
        }
    }

    int capacity, size = 0;
    LinkedList<Node> list = new LinkedList<>();
    Map<Integer, Node> map = new HashMap<>();

    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public LRUCache(int capacity) {
        this.capacity = capacity;

        service.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        System.out.println("Cleaning cache");

        for(Node n : list) {
            if(n.ttl <= System.currentTimeMillis() / 1000) {
                map.remove(n.data);
                list.remove(n);
                System.out.println("removed " + n.data);
            }
        }
    }

    public void add(int data, long ttl) {
        if(size >= capacity) {
            Node node = list.removeLast();
            map.remove(node.data);
            size --;
        }

        Node node = new Node(data, ttl);
        list.addFirst(node);
                    map.put(data, node);
        size ++;
    }

    public int get(int data) {
        if(map.containsKey(data)) {
            Node node = map.get(data);
            list.remove(node);
            node.setNewTTL();
            list.addFirst(node);
            return node.data;
        } else {
            throw new IllegalArgumentException("data not found");
        }
    }

    public void print() {
        for(Node i : list) {
            System.out.println(i.data);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.add(1, 5);
        cache.add(2, 5);
        cache.add(3, 4);
        cache.add(4, 1);
        cache.get(3);
        //cache.print();
    }
}
