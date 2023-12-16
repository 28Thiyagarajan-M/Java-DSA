package Graph;

public class GraphAdjMatrix {
    private boolean adjMatrix[][];
    private int numVertices;

    public GraphAdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    public StringBuffer display() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ":");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s;
    }

    public static void main(String[] args) {
        GraphAdjMatrix g = new GraphAdjMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 1);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.println(g.display());

    }
}
