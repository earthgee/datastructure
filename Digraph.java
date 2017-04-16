package lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by earthgee on 2017/3/14.
 * 有向图
 */
public class Digraph {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Digraph(){
        V=0;
    }

    public Digraph(int V){
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

    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph R=new Digraph(V);
        for(int v=0;v<V;v++){
            for(int w:adj(v)){
                R.addEdge(w,v);
            }
        }
        return R;
    }

}












