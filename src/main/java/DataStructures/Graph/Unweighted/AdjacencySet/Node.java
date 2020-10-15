package DataStructures.Graph.Unweighted.AdjacencySet;

import java.util.*;

public class Node {
    int value;
    Set<Integer> list = new HashSet<>();

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void addEdge(int data) {
        list.add(data);
    }

    public List<Integer> getAdjacencyList() {
        List<Integer> result = new ArrayList<Integer>(list);
        Collections.sort(result);
        return result;
    }
}
