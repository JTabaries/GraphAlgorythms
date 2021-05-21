import java.lang.invoke.StringConcatException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A class to represent the vertices of the graph
 */
public class Vertex implements Comparable<Vertex>{
    /**
     * THe name of the graph
     */
    private final String name;
    /**
     * The preceding vertex in the path, if exists
     */
    private Vertex root;
    /**
     * The lightest edge going out of the current vertex, if exists
     */
    private Edge lightest;
    private ArrayList<Edge> outerEdges;
    private ArrayList<Edge> innerEdges;
    private int pathValue;
    private ArrayList<Vertex> pathTo;
    /**
     * Basic constructor for a vertex
     * @param name the human readable name of the vertex
     */
    public Vertex(String name) {
        this.name=name;
        this.root=this;
        this.lightest=null;
        this.lightest=null;
        this.outerEdges=new ArrayList<Edge>();
        this.innerEdges=new ArrayList<Edge>();
        this.pathTo=new ArrayList<Vertex>();
        this.pathValue=0;
    }

    public int getPathValue() {
        return pathValue;
    }

    public void setPathValue(int pathValue) {
        this.pathValue = pathValue;
    }

    public ArrayList<Vertex> getPathTo() {
        return pathTo;
    }

    public void setPathTo(ArrayList<Vertex> pathTo) {
        this.pathTo = pathTo;
    }

    /**
     * Getter for the name
     * @return name the name of the vertex
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for root vertex.
     * @return root the preceding vertex in the path
     */
    public Vertex getRoot() {return root;}

    /**
     * Setter for root vertex
     * @param root the vertex to be set as root
     */
    public void setRoot(Vertex root) {this.root = root;}

    /**
     * Getter for the lightest edge going out of current vertex
     * @return lightest the lightest edge
     */
    public Edge getLightest() {
        return this.lightest;
    }

    /**
     * Setter for the lightest edge going out of current vertex
     * @param lightest the edge to be set as lightest
     */
    public void setLightest(Edge lightest) {
        this.lightest = lightest;
    }

    public ArrayList<Edge> getOuterEdges() {
        return outerEdges;
    }

    public void setOuterEdges(ArrayList<Edge> outerEdges) {
        this.outerEdges = outerEdges;
    }

    public ArrayList<Edge> getInnerEdges() {
        return innerEdges;
    }

    public void setInnerEdges(ArrayList<Edge> innerEdges) {
        this.innerEdges = innerEdges;
    }

    /**
     * Overridden method to compare two vetices by their weight
     * @param vertex the vertex to be compared to
     * @return int>0 if current edge is heavier, int<0 if current is lighter, 0 else
     */
    @Override
    public int compareTo(Vertex vertex) {
        int val=0;
        if(!this.getName().equals(vertex.getName())){
            val=1;
        }
        return val;
    }
}
