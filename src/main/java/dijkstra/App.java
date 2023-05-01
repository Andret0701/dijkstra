package dijkstra;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        a.addEdge(b, 2);
        a.addEdge(c, 1);
        b.addEdge(e, 3);
        c.addEdge(d, 1);
        c.addEdge(e, 6);
        d.addEdge(e, 1);
        e.addEdge(f, 3);

        ArrayList<Node> path = new Dijkstra().dijkstra(a, f);
        for (Node node : path) {
            System.out.println(node.name);
        }
    }
}
