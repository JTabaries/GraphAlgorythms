import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Sollin {
    /**
     * A list containing the edges of the graph.
     */
    private ArrayList<Edge> edges;
    /**
     * A list containing the vertices of the graph.
     */
    private ArrayList<Vertex> vertices;
    int mstWeight;
    /**
     * Basic constructor for the Kruskal algorithm.
     * @param vertices
     * @param edges
     */
    public Sollin(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        this.edges = edges;
        this.vertices = vertices;
        this.mstWeight=0;
    }
    public Vertex find(Vertex v){
        if(v.getRoot().compareTo(v) != 0){
            v.setRoot(find(v.getRoot()));
        }
        return v.getRoot();
    }
    public void union(Vertex src, Vertex dest){
        Vertex srcroot=find(src);
        Vertex destroot=find(dest);
        destroot.setRoot(srcroot);

    }
    public ArrayList<Edge> execute(){
        int numberOfSubsets=this.vertices.size();
        ArrayList<Edge> remaingedges=new ArrayList<>(this.edges);
        ArrayList<Edge> mst=new ArrayList<>();
        while(mst.size()<this.vertices.size()-1){
            //setting lightest edge for subsets
            for (Edge e:remaingedges) {
                Vertex srcroot=find(e.getU());
                Vertex destroot=find(e.getV());
                if(srcroot.compareTo(destroot) != 0){
                    if(Objects.isNull(srcroot.getLightest()) || srcroot.getLightest().getWeight() > e.getWeight()){
                        srcroot.setLightest(e);
                    }
                    if(Objects.isNull(destroot.getLightest()) || destroot.getLightest().getWeight() > e.getWeight()){
                        destroot.setLightest(e);
                    }
                }
            }
            for(Vertex v:this.vertices){
                if(!Objects.isNull(v.getLightest())){
                    Edge elight=v.getLightest();
                    Vertex src=find(elight.getU());
                    Vertex dest=find(elight.getV());
                    if(src.compareTo(dest) != 0){
                        mst.add(elight);
                        this.mstWeight+=elight.getWeight();
                        remaingedges.remove(elight);
                        union(src,dest);
                        src.setLightest(null);
                        dest.setLightest(null);
                    }
                }
            }

        }
        System.out.println("Minimum spanning tree (using Sollin)");
        for (Edge e:mst) {
            System.out.println("From "+e.getU().getName()+" to "+e.getV().getName()+", weight "+e.getWeight());
        }

        System.out.println("total weight:"+this.mstWeight);
        return mst;
    }
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }
}
