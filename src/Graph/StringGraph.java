package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//class Vertex {
//    String label;
//    Vertex(String label) {
//        this.label = label;
//    }
//
//    @Override
//    public String toString() {
//        return label;
//    }
//
//}

public class StringGraph<T> {
    private Map<T, List<T>> adjacencyList;

    StringGraph() {
        this.adjacencyList = new HashMap<>();

    }

    public void addVertex(T label) {
        adjacencyList.putIfAbsent(label, new ArrayList<>());
    }

    public void removeVertex(T label) {
        adjacencyList.remove(label);
    }

    public void addEdge(T label1, T label2) {
        adjacencyList.get(label1).add(label2);
        adjacencyList.get(label2).add(label1);
    }

    public void removeEdge(T label1, T label2) {
        adjacencyList.get(label1).remove(label2);
        adjacencyList.get(label2).remove(label1);
    }

    public static void main(String[] args) {
        StringGraph sg = new StringGraph();
//        Vertex v1 = new Vertex("NAVEEN");
//
//        Vertex v2 = new Vertex("ANANDH");
//        Vertex v3 = new Vertex("UDAY");
//        sg.addVertex(v1);
//        sg.addVertex(v2);
//        sg.addVertex(v3);
//
//        sg.addEdge(v1, v2);
//        sg.addEdge(v2, v3);
//
//
//        sg.adjacencyList.forEach((key, value) -> System.out.println(key + " " + value));

        sg.addVertex(1);
        sg.addVertex(2);
        sg.addVertex(3);
        sg.addVertex(4);

        sg.addEdge(1, 2);
        sg.addEdge(2, 3);
        sg.addEdge(3, 4);
        sg.addEdge(4, 1);

        sg.adjacencyList.forEach((key, value) -> System.out.println(key + " " + value));




    }

}
