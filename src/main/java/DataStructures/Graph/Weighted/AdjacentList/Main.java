package DataStructures.Graph.Weighted.AdjacentList;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Vertex v0 = new Vertex(0);
//        Vertex v1 = new Vertex(1);
//        Vertex v2 = new Vertex(2);
//        Vertex v3 = new Vertex(3);
//        Vertex v4 = new Vertex(4);
//        Vertex v5 = new Vertex(5);
//
//        Edge e01 = new Edge(v0, v1, 3);
//        Edge e02 = new Edge(v0, v2, 1);
//        Edge e13 = new Edge(v1, v3, 5);
//        Edge e21 = new Edge(v2, v1, 1);
//        Edge e23 = new Edge(v2, v3, 4);
//        Edge e24 = new Edge(v2, v4, 8);
//        Edge e35 = new Edge(v3, v5, 10);
//        Edge e43 = new Edge(v4, v3, 7);
//        Edge e45 = new Edge(v4, v5, 3);

//        v0.getEdges().addAll(Arrays.asList(e01, e02));
//        v1.getEdges().addAll(Arrays.asList(e13));
//        v2.getEdges().addAll(Arrays.asList(e21, e23, e24));
//        v3.getEdges().addAll(Arrays.asList(e35));
//        v4.getEdges().addAll(Arrays.asList(e43, e45));
//
        WeightedGraph w = new WeightedGraph();
//        w.dijkstraAlgorithm(v0, v1);


        /**
         * for Bellman fords algorithm
         */
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        Edge e01 = new Edge(v0, v1, 3);
        Edge e02 = new Edge(v0, v2, 1);
        Edge e13 = new Edge(v1, v3, 5);
        Edge e21 = new Edge(v2, v1, 10);
        Edge e23 = new Edge(v2, v3, 4);
        Edge e24 = new Edge(v2, v4, 8);
        Edge e35 = new Edge(v3, v5, 10);
        Edge e43 = new Edge(v4, v3, 7);
        Edge e45 = new Edge(v4, v5, 3);

        v0.addEdge(e01);v0.addEdge(e02);
        v1.addEdge(e13);
        v2.addEdge(e21);v2.addEdge(e23);v2.addEdge(e24);
        v3.addEdge(e35);
        v4.addEdge(e43);v4.addEdge(e45);

        List<Vertex> vertices = Arrays.asList(v0, v1, v2, v3, v4, v5);
        List<Edge> edges = Arrays.asList(e01, e02, e02, e13, e21, e23, e24, e35, e43, e45);

        //w.bellManFordAlgorithm(v0, v5, vertices, edges);
        w.primAlgorithm(vertices, edges);
    }
}
