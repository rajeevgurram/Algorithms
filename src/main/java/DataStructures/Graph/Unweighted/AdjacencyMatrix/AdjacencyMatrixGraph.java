package DataStructures.Graph.Unweighted.AdjacencyMatrix;

import DataStructures.Graph.Unweighted.Graph;

import java.util.*;

/**
 * we can represent graph using adjacency matrix.
 * total number of vertices.
 * column -> row -> insert 1 to have a edge / relation
 */
public class AdjacencyMatrixGraph implements Graph {
    private int[][] adjacencyMatrix;
    private int numberOfVertices;
    private GraphType graphType = GraphType.DIRECTED;

    public AdjacencyMatrixGraph(int numberOfVertices, GraphType graphType) {
        this.numberOfVertices = numberOfVertices;
        this.graphType = graphType;
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];

        for(int row = 0; row < numberOfVertices; row ++) {
            for(int column = 0; column < numberOfVertices; column ++) {
                adjacencyMatrix[row][column] = 0;
            }
        }
    }

    @Override
    public void addEdge(int vertex1, int vertex2) {
        if(vertex1 >= numberOfVertices || vertex1 < 0 ||
                vertex2 >= numberOfVertices || vertex2 <0) {
            throw new IllegalArgumentException("Vertex number invalid");
        }

        adjacencyMatrix[vertex1][vertex2] = 1;

        if(graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[vertex2][vertex1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        List<Integer> result = new ArrayList<>();

        if(vertex >= numberOfVertices || vertex < 0) {
            throw new IllegalArgumentException("Vertex number invalid");
        }

        for(int column = 0; column < numberOfVertices; column++) {
            if(adjacencyMatrix[vertex][column] != 0) {
                result.add(adjacencyMatrix[vertex][column]);
            }
        }

        Collections.sort(result);
        return result;
    }

    public void DFS() {
        DFS_Recursive(3, new HashSet<>());
    }

    private void DFS_Recursive(int row, Set<Integer> visitedNodes) {
        if(!visitedNodes.contains(row)) {
            visitedNodes.add(row);

            for(int column = 0; column < adjacencyMatrix.length; column ++) {
                if(adjacencyMatrix[row][column] == 1) {
                    System.out.println(row + "->" + column);
                    DFS_Recursive(column, visitedNodes);
                }
            }
        }
    }

    public void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(4);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int row = queue.remove();
            if(!visited.contains(row)) {
                visited.add(row);
                for (int column = 0; column < numberOfVertices; column++) {
                    if (adjacencyMatrix[row][column] == 1) {
                        System.out.println(row + "->" + column);
                        queue.add(column);
                    }
                }
            }
        }
    }
}
