package DataStructures.Graph.Unweighted.AdjacencySet_Vertex;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int data;
    private List<Vertex> vertices;

    public Vertex(int data) {
        this.data = data;
        vertices = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
