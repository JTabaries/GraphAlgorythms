

import java.util.ArrayList;

public class road {
    public static void main(String[] args){
        Graph g=new Graph(true);
        Vertex A=new Vertex("A");
        Vertex B=new Vertex("B");
        Vertex C=new Vertex("C");
        Vertex D=new Vertex("D");
        Vertex E=new Vertex("E");
        Vertex F=new Vertex("F");
        Vertex G=new Vertex("G");
        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        g.addVertex(E);
        g.addVertex(F);
        g.addVertex(G);
        g.addEdge(new Edge(A,B,8));
        g.addEdge(new Edge(B,C,2));
        g.addEdge(new Edge(C,D,5));
        g.addEdge(new Edge(D,E,3));
        g.addEdge(new Edge(E,A,11));
        g.addEdge(new Edge(C,G,14));
        g.addEdge(new Edge(G,B,6));
        g.addEdge(new Edge(E,F,2));
        g.addEdge(new Edge(F,G,9));
        g.addEdge(new Edge(F,D,7));
        Dijkstra d=new Dijkstra(g,C);
        d.execute();
    }
}
