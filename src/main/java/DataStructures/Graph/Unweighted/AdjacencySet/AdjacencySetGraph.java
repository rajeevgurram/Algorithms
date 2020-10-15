package DataStructures.Graph.Unweighted.AdjacencySet;

import DataStructures.Graph.Unweighted.DistanceInfo;
import DataStructures.Graph.Unweighted.Graph;

import java.util.*;

/**
 * we can represent graph using adjacency set.
 */
public class AdjacencySetGraph implements Graph {
    private List<Node> adjacencySet;
    private int numberOfVertices;
    private GraphType graphType;

    public AdjacencySetGraph(int numberOfVertices, GraphType graphType) {
        this.numberOfVertices = numberOfVertices;
        this.graphType = graphType;
        adjacencySet = new ArrayList<>();

        for(int i = 0; i < numberOfVertices; i ++) {
            adjacencySet.add(new Node(i));
        }
    }

    @Override
    public void addEdge(int vertex1, int vertex2) {
        if(vertex1 >= numberOfVertices || vertex1 < 0 ||
                vertex2 >= numberOfVertices || vertex2 <0) {
            throw new IllegalArgumentException("Vertex number invalid");
        }

        adjacencySet.get(vertex1).addEdge(vertex2);
        if(graphType == GraphType.UNDIRECTED) {
            adjacencySet.get(vertex2).addEdge(vertex1);
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencySet.get(vertex)
                .getAdjacencyList();
    }

    /**
     * Depth first traversal of Graph.
     */
    public void depthFirstTraversal() {
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        for(int i = 0; i < numberOfVertices; i ++) {
            visitedMap.put(i, false);
        }
        depthFirstTraversal(adjacencySet.get(0).value, visitedMap);
    }

    private void depthFirstTraversal(int vertex, Map<Integer, Boolean> visitedMap) {
        if(visitedMap.get(vertex)) {
            return;
        }

        visitedMap.put(vertex, true);
        List<Integer> adjacentList = adjacencySet.get(vertex)
                .getAdjacencyList();
        for (int value : adjacentList) {
            depthFirstTraversal(value, visitedMap);
        }
        System.out.println(vertex);
    }

    /**
     * Breadth first traversal of the Graph.
     */
    public void breadthFirstTraversal() {
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        for(int i = 0; i < numberOfVertices; i ++) {
            visitedMap.put(i, false);
        }
        breadthFirstTraversal(adjacencySet.get(0).value, visitedMap);
    }

    private void breadthFirstTraversal(int vertex, Map<Integer, Boolean> visitedMap) {
        List<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int data = queue.iterator().next();
            queue.remove(0);

            if(visitedMap.get(data)) {
                continue;
            }

            visitedMap.put(data, true);
            System.out.println(data);
            List<Integer> adjacentList = adjacencySet.get(data).getAdjacencyList();
            queue.addAll(adjacentList);
        }
    }

    /**
     * Topological Sorting.
     * 1.) Find 0 InDegree Vertex
     * 2.) Reduce InDegree values for all it's adjacent vertexes
     * 3.) Repeat Step 1 and 2
     */
    public void topologicalSort() {
        Map<Integer, Integer> map = new HashMap<>();

        // Map In Degree for all Nodes
        for(Node n : adjacencySet) {
            List<Integer> adjacencyList = n.getAdjacencyList();

            for(int i : adjacencyList) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            map.put(n.value, map.getOrDefault(n.value, 0));
        }

        for(int i = 0; i < numberOfVertices; i ++) {
            int zeroInDegreeValue = getZeroInDegreeValue(map);
            System.out.print(zeroInDegreeValue + " --> ");
            removeLink(map, zeroInDegreeValue);
        }
    }

    private int getZeroInDegreeValue(Map<Integer, Integer> map) {
        for(int i : map.keySet()) {
            if(map.get(i) == 0) {
                return i;
            }
        }

        return -1;
    }

    private void removeLink(Map<Integer, Integer> map, int value) {
        List<Integer> adjacencyList = adjacencySet.get(value)
                .getAdjacencyList();

        for(int i : adjacencyList) {
            map.put(i, map.get(i) - 1);
        }
        map.put(value, map.get(value) - 1);
    }

    /**
     * finding shortest path between source and destination.
     * @param source
     * @param destination
     */
    public void findShortestDistance(int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(source);

        Stack<Integer> path = new Stack<>();
        path.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            path.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if(previousVertex == -1) {
            System.out.println("No path from " + source + " to " + destination);
        } else {
            System.out.print(source);
            while (!path.isEmpty()) {
                System.out.print("-->" + path.pop());
            }
        }
    }

    private Map<Integer, DistanceInfo> buildDistanceTable(final int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for(int i = 0; i < numberOfVertices; i ++) {
            distanceTable.put(i, new DistanceInfo());
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentVertex = queue.pollFirst();
            List<Integer> adjacencyList = getAdjacentVertices(currentVertex);

            for(int i : adjacencyList) {
                int currentDistance = distanceTable.get(i).getDistance();
                if(currentDistance == -1) {
                    currentDistance = 1 + distanceTable.get(i).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);
                }

                if(getAdjacentVertices(i).size() > 0) {
                    queue.add(i);
                }
            }
        }

        return distanceTable;
    }
}
