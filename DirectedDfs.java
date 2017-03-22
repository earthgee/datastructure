package lib;

/**
 * Created by earthgee on 2017/3/22.
 * 有向图dfs
 */
public class DirectedDfs {

    private boolean[] marked;

    public DirectedDfs(Digraph G,int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    public DirectedDfs(Digraph G,Iterable<Integer> sources){
        marked=new boolean[G.V()];
        for(int s:sources){
            if(!marked[s]) dfs(G,s);
        }
    }

    private void dfs(Digraph G,int v){
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w]) dfs(G,w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

}












