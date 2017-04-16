package lib;

import java.util.ArrayList;
import java.util.List;

import graph.EdgeWeightGraph;

/**
 * Created by earthgee on 17/4/16.
 * 无环加权有向图的最短路径
 */
public class AcyclicSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G,int s){
        edgeTo=new DirectedEdge[G.V()];
        distTo=new double[G.V()];

        for(int v=0;v<G.V();v++){
            distTo[v]=Double.MAX_VALUE;
        }
        distTo[s]=0.0;

        Topological top=new Topological(G);
        for(int v:top.order()){
            relax(G,v);
        }
    }

    private void relax(EdgeWeightedDigraph G,int v){
        for(DirectedEdge e:G.adj2(v)){
            int w=e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w]=distTo[v]+e.weight();
                edgeTo[w]=e;
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

}
