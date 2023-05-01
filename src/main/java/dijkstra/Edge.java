package dijkstra;

public class Edge {
    public double distance;
    public Node node;

    public Edge(Node node, double distance) {
        this.node = node;
        this.distance = distance;
    }
}
