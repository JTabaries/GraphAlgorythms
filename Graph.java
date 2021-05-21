import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private final boolean directed;

    public Graph(boolean directed) {
        this.vertices = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
        this.directed = directed;
    }
    public void addVertex(Vertex v){
        this.vertices.add(v);
    }
    public void addEdge(Edge e){
        if(this.directed){
            Vertex src=e.getU();
            src.getOuterEdges().add(e);
            Vertex dest=e.getV();
            dest.getInnerEdges().add(e);
        }else{
        }
        this.edges.add(e);
    }
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public boolean isDirected() {
        return directed;
    }
}
