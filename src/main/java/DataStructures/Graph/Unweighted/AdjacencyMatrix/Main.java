package DataStructures.Graph.Unweighted.AdjacencyMatrix;

import DataStructures.Graph.Unweighted.Graph;

public class Main {
    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);

        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        graph.getAdjacentVertices(1);
        System.out.println("");

        graph.DFS();
        graph.BFS();
    }
}
