package lib;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by earthgee on 17/4/5.
 */
public class SP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public SP(EdgeWeightedDigraph G,int s){
        edgeTo=new DirectedEdge[G.V()];
        distTo=new double[G.V()];
        pq=new IndexMinPQ<>(G.V());

        for(int v=0;v<G.V();v++){
            distTo[v]=Double.MAX_VALUE;
        }
        distTo[s]=0.0;
        pq.insert(s,0.0);
        while (!pq.isEmpty()){
            relax(G,pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G,int v){
        for(DirectedEdge e:G.adj(v)){
            int w=e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w]=distTo[v]+e.weight();
                edgeTo[w]=e;
                if(pq.contains(w)) pq.change(w,distTo(w));
                else pq.insert(w,distTo[w]);
            }
        }
    }

    double distTo(int v){
        return distTo[v];
    }

    boolean hasPathTo(int v){
        return distTo[v]!=Double.MAX_VALUE;
    }

    Iterable<DirectedEdge> pathTo(int v){
        List<DirectedEdge> res=new ArrayList<>();
        while (edgeTo[v]!=null){
            res.add(edgeTo[v]);
            v=edgeTo[v].from();
        }
        return res;
    }

    private void relax(DirectedEdge e){
        int v=e.from(),w=e.to();
        if(distTo[w]>distTo[v]+e.weight()){
            distTo[w]=distTo[v]+e.weight();
            edgeTo[w]=e;
        }
    }

}
