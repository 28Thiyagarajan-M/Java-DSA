package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Vertex, List<Vertex>> graph;
    int vertices;

    Graph(int vertices) {
        this.vertices = vertices;
        graph = new HashMap<Vertex, List<Vertex>>(vertices);
    }

    private class Vertex {
        String label;

        Vertex(String label) {
            this.label = label;
        }
    }


    public void addVertex(String label) {
        graph.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);

        graph.values().stream().forEach(e -> e.remove(v));
        graph.remove(v);
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> eV1 = graph.get(v1);
        List<Vertex> eV2 = graph.get(v2);

        if (eV1 != null) {
            eV1.remove(v2);
        }
        if (eV2 != null) {
            eV2.remove(v1);
        }

    }

    public List<Vertex> getAdjVertices(String label) {
        return graph.get(new Vertex(label));
    }

    public int map() {
        Map<Integer, Integer> m = new HashMap<>(10);
        return m.size();
    }


    public static void main(String[] args) {
        Graph graph = new Graph(20);
        System.out.println(graph.graph);
        graph.addVertex("Bob");

        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
    }
}
