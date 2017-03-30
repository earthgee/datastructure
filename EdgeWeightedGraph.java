package lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by earthgee on 2017/3/29.
 * 加权无向图
 */
public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private List<Edge>[] adj;

    public EdgeWeightedGraph(int V){
        this.V=V;
        this.E=0;
        adj=new ArrayList[V];
        for(int v=0;v<V;v++){
            adj[v]=new ArrayList<>();
        }
    }

    int V(){
        return V;
    }

    int E(){
        return E;
    }

    void addEdge(Edge e){
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    Iterable<Edge> adj(int v){
        return adj[v];
    }

    Iterable<Edge> edges(){
        List<Edge> b=new ArrayList<>();
        for(int v=0;v<V;v++){
            for(Edge e:adj[v]){
                if(e.other(v)>v) b.add(e);
            }
        }
        return b;
    }

}









