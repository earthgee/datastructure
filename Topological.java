package lib;

/**
 * Created by earthgee on 2017/3/26.
 * 有向图拓扑排序
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph G){
        DirectedCycle cycleFinder=new DirectedCycle(G);

        if(!cycleFinder.hasCycle()){
            DepthFirstOrder dfs=new DepthFirstOrder(G);
            order=dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order!=null;
    }

}
