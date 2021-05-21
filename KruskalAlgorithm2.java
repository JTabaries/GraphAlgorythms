import java.util.ArrayList;
import java.util.Comparator;

public class KruskalAlgorithm2 {
    /**
     * A list containing the edges of the graph.
     */
    private ArrayList<Edge> edges;
    /**
     * A list containing the vertices of the graph.
     */
    private ArrayList<Vertex> vertices;
    /**
     * A variable to store le minimum spanning tree total weight
     */
    private int mstWeight;
    /**
     * Basic constructor for the Kruskal algorithm.
     * @param vertices
     * @param edges
     */
    public KruskalAlgorithm2(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        this.vertices=vertices;
        this.edges = edges;
        this.mstWeight=0;
    }

    /**
     * Method to find recursively the root edge
     * @param v the current vertex
     * @return root the root for the current vertex
     */
    public Vertex find(Vertex v){
        if(v.getRoot().compareTo(v) != 0){
            v.setRoot(find(v.getRoot()));
        }
        return v.getRoot();
    }

    /**
     * Performs a union of the two subsets, ie sets a vertex as root of the other
     * @param src the source vertex
     * @param dest the destination vertex
     */
    public void union(Vertex src, Vertex dest){
        Vertex srcroot=find(src);
        Vertex destroot=find(dest);
        destroot.setRoot(srcroot);

    }
    /**
     * An implementation of the kruskal algorithm.
     * @return mst a list containing the minimum spanning tree.
     */
    public ArrayList<Edge> execute(){
        //sorting the edges by ascending weight
        this.edges.sort(Comparator.comparingDouble(Edge::getWeight));
        ArrayList<Edge> mst=new ArrayList<>();
        int i=0;
        while(mst.size()<this.vertices.size()-1){
            Edge edge=this.edges.get(i++);
            Vertex subnet1=find(edge.getU());
            Vertex subnet2=find(edge.getV());
            if(subnet1.compareTo(subnet2) != 0){
                mst.add(edge);
                this.mstWeight=this.mstWeight+edge.getWeight();
                union(subnet1, subnet2);
            }

        }
        System.out.println("Minimum spanning tree (using Kruskal)");
        for(Edge e : mst){
            System.out.println("From "+e.getU().getName()+" to "+e.getV().getName()+", weight "+e.getWeight());
        }
        System.out.println("total weight:"+this.mstWeight);
        return mst;
    }
}
