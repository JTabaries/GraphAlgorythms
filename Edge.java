/**
 * A class to represent the edges of the graph
 */
public class Edge implements Comparable<Edge>{
    /**
     * The source vertex
     */
    private final Vertex u;
    /**
     * The destination vertex
     */
    private final Vertex v;
    /**
     * The edge's weight
     */
    private final int weight;

    /**
     * Basic constructor for an edge
     * @param u source vertex
     * @param v destination vertex
     * @param weight the edge's weight
     */
    public Edge(Vertex u, Vertex v, int weight) {
        this.u = u;
        this.v = v;
        this.weight=weight;
    }

    /**
     * Getter for the source
     * @return u the source vertex
     */
    public Vertex getU() {
        return u;
    }

    /**
     * Getter for the destination
     * @return v the destination vertex
     */
    public Vertex getV() {
        return v;
    }

    /**
     * Getter for the edge's weight
     * @return weight the edge's weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Overridden method to compare two edges by their weight
     * @param e the edge to be compared to.
     * @return int>0 if current edge is heavier, int<0 if current is lighter, 0 else
     */
    @Override
    public int compareTo(Edge e) {
        return this.getWeight()-e.getWeight();
    }
}
