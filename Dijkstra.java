import java.util.ArrayList;
import java.util.Comparator;

public class Dijkstra {
    private Graph graph;
    private Vertex source;
    public Dijkstra(Graph graph, Vertex source) {
        this.graph = graph;
        this.source = source;
        //init path
        for (Vertex v:graph.getVertices()) {
            if(v.compareTo(this.source) == 0){
                v.setPathValue(0);
            }else{
                v.setPathValue(Integer.MAX_VALUE);
            }
            v.getPathTo().add(this.source);
        }
    }
    public Vertex removeMin(ArrayList<Vertex> list){
        list.sort(Comparator.comparingInt(Vertex::getPathValue));
        return list.remove(0);

    }
    public ArrayList<Vertex> execute(){
        ArrayList<Vertex> initial=this.graph.getVertices();
        ArrayList<Vertex> solution=new ArrayList<>();
        Vertex current;
        while(initial.size() !=0){
            current=removeMin(initial);
            //current.getPathTo().add(current);
            solution.add(current);
            for(Edge e:current.getOuterEdges()){
                Vertex src=e.getU();
                Vertex dest=e.getV();
                int dist=current.getPathValue()+e.getWeight();
                if(dist < dest.getPathValue()){
                    dest.setPathValue(dist);
                    dest.getPathTo().clear();
                    dest.getPathTo().addAll(src.getPathTo());
                    dest.getPathTo().add(dest);

                }

            }
        }
        System.out.println("Shortest path (using Dijkstra)");
        for (Vertex v:solution) {
            System.out.print("Path from "+this.getSource().getName()+" to "+v.getName()+" : {");
            for (Vertex u : v.getPathTo()) {
                System.out.print(u.getName());
            };
            System.out.println("} - path value: "+v.getPathValue());
        }
        return solution;
    }
    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }
}
