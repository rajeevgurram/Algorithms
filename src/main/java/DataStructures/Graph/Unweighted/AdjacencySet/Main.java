package DataStructures.Graph.Unweighted.AdjacencySet;

import DataStructures.Graph.Unweighted.Graph;

public class Main {
    public static void main(String[] args) {
        AdjacencySetGraph graph = new AdjacencySetGraph(5, Graph.GraphType.DIRECTED);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        //graph.breadthFirstTraversal();

        //graph.topologicalSort();
        graph.findShortestDistance(0, 4);

    }
}
