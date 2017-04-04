package lib;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by earthgee on 17/4/4.
 */
public class KruskalMST {

    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G){
        mst=new LinkedList<>();
        MinProrityQueue<Edge> pq=new MinProrityQueue(G.edges());
        UF uf=new UF(G.V());

        while(!pq.isEmpty()&&mst.size()<G.V()-1){
            Edge e=pq.delMin();
            int v=e.either(),w=e.other(v);
            if(uf.connected(v,w)) continue;
            uf.union(v,w);
            mst.offer(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

}
