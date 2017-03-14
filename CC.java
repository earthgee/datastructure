package lib;

/**
 * Created by earthgee on 2017/3/12.
 */
public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G){
        marked=new boolean[G.V()];
        id=new int[G.V()];
        for(int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        id[v]=count;
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    boolean connected(int v,int w){
        return id[v]==id[w];
    }

    public int id(int v){
        return id[v];
    }

    int count(){
        return count;
    }


}
