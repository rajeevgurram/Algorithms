package DataStructures.Graph.Weighted.AdjacentList;

import java.util.*;

public class WeightedGraph {
    public WeightedGraph() {}

    /**
     * dijkstra Algorithm used for finding shortest path for weighted directed graph
     * similar to non weight, except we use priority queue.
     * @param source
     * @param destination
     */
    public void dijkstraAlgorithm(final Vertex source, final Vertex destination) {
        source.setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            final Vertex vertex = queue.poll();

            for(final Edge edge : vertex.getEdges()) {
                int newDistance = vertex.getDistance() + edge.getWeight();

                if(edge.getDestination().getDistance() > newDistance) {
                    edge.getDestination().setDistance(newDistance);
                    edge.getDestination().setLastVertex(vertex);
                    queue.add(edge.getDestination());
                }
            }
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex path = destination;
        while (path != null && path != source) {
            stack.add(path);
            path = path.getLastVertex();
        }

        if(path == source) {
            stack.add(path);
            while (!stack.isEmpty()) {
                System.out.print("->" + stack.pop().getData());
            }
        } else {
            throw new IllegalArgumentException("No Path found from source");
        }
    }

    /**
     * bellman ford algorithm used to find the shortest path for weighted NEGATIVE graph.
     * It basically needs to traverse N-1 times to relax all edges.
     *
     * https://www.youtube.com/watch?v=FtN3BYH2Zes
     */
    public void bellManFordAlgorithm(final Vertex source, final Vertex destination,
                                     final List<Vertex> vertices, final List<Edge> edges) {
        source.setDistance(0);

        for(int i = 0; i < vertices.size(); i ++) {
            for(Edge edge : edges) {
                Vertex u = edge.getSource();
                Vertex v = edge.getDestination();

                int currentDistance = u.getDistance() + edge.getWeight();

                if(currentDistance < v.getDistance()) {
                    v.setDistance(currentDistance);
                    v.setLastVertex(u);
                }
            }
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex temp = destination;

        while (temp != null) {
            stack.add(temp);
            temp = temp.getLastVertex();
        }

        while (!stack.isEmpty()) {
            System.out.print("->" + stack.pop().getData());
        }
    }

    /**
     * Prim algorithm is used to create a minimum spanning tree.
     * A spanning tree is a tree which connects to all vertices with n-1 edges
     * Prim algorithm works by selecting a least weighted edge initially,
     * and then select next least edge that connects to previously selected edge
     */
    public void primAlgorithm(final List<Vertex> vertices, final List<Edge> edges) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        Collections.sort(edges);
        queue.add(edges.get(0));

        int index = 1;
        int sum = 0;
        while(!queue.isEmpty() && index < vertices.size()) {
            Edge edge = queue.poll();
            sum += edge.getWeight();
            Vertex v = edge.getDestination();

            queue.addAll(v.getEdges());
            index ++;
        }

//        while (!queue.isEmpty()) {
//            Edge edge = queue.poll();
//
//            Vertex u = edge.getSource();
//            Vertex v = edge.getDestination();
//
//            u.getEdges().remove(edge);
//            edge.setSource(null);
//            edge.setDestination(null);
//        }
        System.out.println(sum);
    }
}
