package DataStructures.Graph.Unweighted.AdjacencySet_Vertex;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        AdjacencyGraph_Vertex graph = new AdjacencyGraph_Vertex();
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);

        graph.addEdge(v2, v4);

        graph.addEdge(v3, v5);
        //graph.addEdge(v3, v1);

        graph.addEdge(v4, v3);
        graph.addEdge(v4, v5);

        //1, 2, 3, 4, 5
        System.out.print("BFS: ");
        graph.BFS(v1);

        System.out.println();
        System.out.print("DFS: ");
        //1, 2, 4, 5, 3
        graph.DFS(v1);

        System.out.println("\nShortest Path");
        graph.findShortestPath(v1, v3);

        System.out.println("\n\nTopological Sort: ");

        List<Vertex> vertexList = new ArrayList<>();

        Vertex newV0 = new Vertex(0);
        Vertex newV1 = new Vertex(1);
        Vertex newV2 = new Vertex(2);
        Vertex newV3 = new Vertex(3);
        Vertex newV4 = new Vertex(4);
        Vertex newV5 = new Vertex(5);

        vertexList.add(newV0);
        vertexList.add(newV1);
        vertexList.add(newV2);
        vertexList.add(newV3);
        vertexList.add(newV4);
        vertexList.add(newV5);

        graph.addEdge(newV5, newV0);
        graph.addEdge(newV5, newV2);

        graph.addEdge(newV4, newV0);
        graph.addEdge(newV4, newV1);

        graph.addEdge(newV2, newV3);

        graph.addEdge(newV3, newV1);

        // Method 1
        //graph.topologicalSort(vertexList);

        //Method 2
        for(Vertex v : vertexList) {
            graph.DepthFirstSearch(v);
        }
        Stack<Vertex> stack = graph.getTopologicalStack();
        while (!stack.empty()) {
            System.out.print("->" + stack.pop().getData());
        }
    }
}
