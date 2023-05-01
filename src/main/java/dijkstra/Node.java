package dijkstra;

import java.util.ArrayList;

public class Node {
    public String name;
    public ArrayList<Edge> edges = new ArrayList<>();

    private Node(String name) {
        this.name = name;
    }

    public void addEdge(Node neighbour, double distance) {
        Edge edge = new Edge(neighbour, distance);
        edges.add(edge);
    }
}