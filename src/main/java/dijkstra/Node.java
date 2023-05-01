package dijkstra;

import java.util.ArrayList;

public class Node {
    public String name;
    public ArrayList<Edge> edges = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDirectedEdge(Node neighbour, double distance) {
        Edge edge = new Edge(neighbour, distance);
        edges.add(edge);
    }

    public void addEdge(Node neighbour, double distance) {
        addDirectedEdge(neighbour, distance);
        neighbour.addDirectedEdge(this, distance);
    }
}