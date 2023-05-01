package dijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

public class Dijkstra {
    private class Stack {
        private ArrayList<Edge> stack = new ArrayList<>();

        public void push(Node node, double distance) {
            stack.add(new Edge(node, distance));
        }

        public Edge pop() {
            Edge shortest = getShortest();
            stack.remove(shortest);
            return shortest;
        }

        private Edge getShortest() {
            Edge shortest = stack.get(0);
            for (Edge edge : stack) {
                if (edge.distance < shortest.distance)
                    shortest = edge;
            }
            return shortest;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public ArrayList<Node> dijkstra(Node start, Node end) {
        Set<Node> visited = new HashSet<>();
        HashMap<Node, Node> previous = new HashMap<>();

        Stack unvisited = new Stack();
        unvisited.push(start, 0);

        while (!unvisited.isEmpty()) {
            Edge current = unvisited.pop();
            visited.add(current.node);

            if (current.node == end)
                return getPath(end, previous);

            for (Edge edge : current.node.edges) {
                if (!visited.contains(edge.node)) {
                    double totalDistance = current.distance + edge.distance;
                    unvisited.push(edge.node, totalDistance);
                    previous.put(edge.node, current.node);
                }
            }
        }

        return null;
    }

    private ArrayList<Node> getPath(Node end, HashMap<Node, Node> previous) {
        ArrayList<Node> path = new ArrayList<>();
        Node current = end;
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }
        return path;
    }
}
