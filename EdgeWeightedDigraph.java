package lib;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by earthgee on 17/4/4.
 */
public class EdgeWeightedDigraph extends Digraph{

    private final int V;
    private int E;
    private List<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V){
        this.V=V;
        this.E=0;
        adj=new ArrayList[V];
        for(int v=0;v<V;v++){
            adj[v]=new ArrayList<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    void addEdge(DirectedEdge e){
        adj[e.from()].add(e);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return super.adj(v);
    }

    Iterable<DirectedEdge> adj2(int v){
        return adj[v];
    }

    Iterable<DirectedEdge> edges(){
        List<DirectedEdge> res=
                new ArrayList<>();
        for(int v=0;v<V;v++){
            for(DirectedEdge e:adj[v]){
                res.add(e);
            }
        }
        return res;
    }

}









