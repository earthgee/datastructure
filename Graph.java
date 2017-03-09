package lib;

import java.util.ArrayList;

/**
 * Created by earthgee on 2017/3/9.
 */
public class Graph {

    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    public Graph(int V){
        this.V=V;
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

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}














