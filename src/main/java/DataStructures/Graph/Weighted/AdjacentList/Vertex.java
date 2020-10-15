package DataStructures.Graph.Weighted.AdjacentList;

import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private int data;
    private List<Edge> edges;
    private Vertex lastVertex;
    private Integer distance;

    public Vertex(int data) {
        this.data = data;
        this.edges = new LinkedList<>();
        this.distance = Integer.MAX_VALUE;
    }

    public Vertex(int data, List<Edge> edges, Vertex lastVertex, Integer distance) {
        this.data = data;
        this.edges = edges;
        this.lastVertex = lastVertex;
        this.distance = distance;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(final Edge edge) {
        edges.add(edge);
    }

    public Vertex getLastVertex() {
        return lastVertex;
    }

    public void setLastVertex(Vertex lastVertex) {
        this.lastVertex = lastVertex;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex other) {
        return this.getDistance().compareTo(other.getDistance());
    }
}
