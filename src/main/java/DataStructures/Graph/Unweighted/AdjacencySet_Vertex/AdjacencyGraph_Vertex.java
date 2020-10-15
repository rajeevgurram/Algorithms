package DataStructures.Graph.Unweighted.AdjacencySet_Vertex;

import DataStructures.Graph.Unweighted.DistanceInfo;
import DataStructures.Graph.Unweighted.Graph;

import java.util.*;

public class AdjacencyGraph_Vertex {
    Graph.GraphType graphType = Graph.GraphType.DIRECTED;

    // Connect a vertex with another using an Edge
    public void addEdge(final Vertex v1, final Vertex v2) {
        v1.getVertices().add(v2);

        if(graphType == Graph.GraphType.UNDIRECTED) {
            v2.getVertices().add(v1);
        }
    }

    /**
     * Iterate using BFS
     * Applications:
     *  1.) Shortest Path
     *  2.) Web Crawler
     */
    public void BFS(final Vertex root) {
        final Queue<Vertex> queue = new LinkedList<>();
        final Set<Integer> visitedVertexes = new HashSet<>();

        if(root == null) {
            throw new IllegalArgumentException("Graph not found");
        }

        queue.add(root);
        visitedVertexes.add(root.getData());

        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            System.out.print("->" + vertex.getData());

            for(Vertex data : vertex.getVertices()) {
                if(!visitedVertexes.contains(data.getData())) {
                    queue.add(data);
                    visitedVertexes.add(data.getData());
                }
            }
        }
    }

    /**
     * Iterate using DFS
     * Applications:
     *  1.) Solving Maze
     */
    public void DFS(final Vertex root) {
        if(root == null) {
            throw new IllegalArgumentException("Graph is empty");
        }

        DFS_Recursive(root, new HashSet<>());
        System.out.println();
        DFS_Iterative(root);
    }

    private void DFS_Recursive(final Vertex vertex, final Set<Integer> visitedVertexes) {
        if(vertex == null) {
            return;
        }

        System.out.print("->" + vertex.getData());
        for(final Vertex children_vertex : vertex.getVertices()) {
            if(!visitedVertexes.contains(children_vertex.getData())) {
                visitedVertexes.add(children_vertex.getData());
                DFS_Recursive(children_vertex, visitedVertexes);
            }
        }
    }

    private void DFS_Iterative(final Vertex vertex) {
        Stack<Vertex> stack = new Stack<>();
        Set<Integer> visitedVertexes = new HashSet<>();

        stack.add(vertex);
        visitedVertexes.add(vertex.getData());

        while (!stack.isEmpty()) {
            Vertex children_vertex = stack.pop();
            System.out.print("->" + children_vertex.getData());
            for(Vertex children :  children_vertex.getVertices()) {
                if (!visitedVertexes.contains(children.getData())) {
                    stack.add(children);
                    visitedVertexes.add(children.getData());
                }
            }
        }
    }

    /**
     * Topological Sorting
     * Applications:
     *  1.) Sequence of Tasks
     *  2.) Project management
     *  3.) Hamiltonian Path -> Directed / Undirected, visits each node only once.
     *      finding Hamiltonian Path is NP Complete problem
     *  4.) Creating course syllabus
     *  5.) Maven Multi Module Building
     */
    public void topologicalSort(final List<Vertex> vertexList) {
        final Map<Vertex, Integer> inDegreeMap = new HashMap<>();
        buildInDegreeMap(vertexList, inDegreeMap);

        while (!inDegreeMap.isEmpty()) {
            final Vertex zeroInDegreeVertex = getZeroInDegreeVertex(inDegreeMap);
            if(zeroInDegreeVertex == null) {
                throw new RuntimeException("Can not find next zero in-degree vertex.");
            }
            System.out.print("->" + zeroInDegreeVertex.getData());
            removeZeroInDegreeVertex(zeroInDegreeVertex, inDegreeMap);
        }
    }

    // use BFS to create in-degree map. it is to map how many in-degree number for each vertex
    // It should have at least one vertex with 0 in-degree vertex or else it's a cyclic dependency
    private void buildInDegreeMap(final List<Vertex> vertexList,
                                  final Map<Vertex, Integer> inDegreeMap) {
        final Set<Integer> visitedVertex = new HashSet<>();

        for(Vertex vertex : vertexList) {
            if(!visitedVertex.contains(vertex.getData())) {
                visitedVertex.add(vertex.getData());
                for(Vertex _vertex : vertex.getVertices()) {
                    inDegreeMap.put(_vertex,
                            inDegreeMap.getOrDefault(_vertex, 0) + 1);
                }
                inDegreeMap.put(vertex, inDegreeMap.getOrDefault(vertex, 0));
            }
        }
    }

    private Vertex getZeroInDegreeVertex(final Map<Vertex, Integer> inDegreeMap) {
        Vertex zeroInDegreeVertex = null;
        for(Vertex vertex : inDegreeMap.keySet()) {
            if(inDegreeMap.get(vertex) == 0) {
                zeroInDegreeVertex = vertex;
                break;
            }
        }

        return zeroInDegreeVertex;
    }

    private void removeZeroInDegreeVertex(final Vertex vertex,
                                          final Map<Vertex, Integer> inDegreeMap) {
        // removing the processed in-degree vertex from the map
        inDegreeMap.remove(vertex);

        // -1 to all vertexes pointing from the processed vertex
        for(Vertex _vertex : vertex.getVertices()) {
            inDegreeMap.put(_vertex, inDegreeMap.get(_vertex) - 1);
        }
    }

    // Topological Sorting Using DFS
    private final Stack<Vertex> stack = new Stack<>();
    private final Set<Integer> visited = new HashSet<>();
    public void DepthFirstSearch(final Vertex vertex) {
        if(!visited.contains(vertex.getData())) {
            visited.add(vertex.getData());
            for (Vertex v : vertex.getVertices()) {
                if (!visited.contains(v.getData())) {
                    DepthFirstSearch(v);
                }
            }

            stack.push(vertex);
        }
    }
    public Stack<Vertex> getTopologicalStack() {
        return stack;
    }

    public void findShortestPath(final Vertex source, final Vertex destination) {
        Map<Integer, DistanceInfo> distanceInfoMap = buildDistanceMap(source);
        Stack<Integer> stack = new Stack<>();

        DistanceInfo info = distanceInfoMap.get(destination.getData());
        if(destination == null) {
            throw new IllegalArgumentException("Destination not found");
        }

        stack.add(destination.getData());
        while (info != null && info.getLastVertex() != source.getData()) {
            stack.add(info.getLastVertex());
            info = distanceInfoMap.get(info.getLastVertex());
        }

        if(info == null) {
            throw new IllegalArgumentException("No path found");
        }

        System.out.print("->" + source.getData());
        while (!stack.empty()) {
            System.out.print("->" + stack.pop());
        }
    }

    private Map<Integer, DistanceInfo> buildDistanceMap(final Vertex source) {
        final Map<Integer, DistanceInfo> distanceInfo = new HashMap<>();
        final Queue<Vertex> queue = new LinkedList<>();
        final Set<Vertex> visited = new HashSet<>();

        DistanceInfo sourceInfo = new DistanceInfo();
        sourceInfo.setLastVertex(-1);
        sourceInfo.setDistance(0);
        distanceInfo.put(source.getData(), sourceInfo);

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            final Vertex vertex = queue.remove();
            DistanceInfo child_info = distanceInfo.get(vertex.getData());
            for(Vertex child_vertex : vertex.getVertices()) {
                if(!visited.contains(child_vertex)) {
                    DistanceInfo info = new DistanceInfo();
                    info.setLastVertex(vertex.getData());
                    info.setDistance(child_info.getDistance() + 1);
                    distanceInfo.put(child_vertex.getData(), info);
                    queue.add(child_vertex);
                    visited.add(child_vertex);
                }
            }
        }

        return distanceInfo;
    }
}
