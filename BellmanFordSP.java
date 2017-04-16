package lib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by earthgee on 17/4/16.
 */
public class BellmanFordSP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDigraph G,int s){
        distTo=new double[G.V()];
        edgeTo=new DirectedEdge[G.V()];
        onQ=new boolean[G.V()];
        queue=new LinkedList<>();
        for(int v=0;v<G.V();v++){
            distTo[v]=Double.MAX_VALUE;
        }
        distTo[s]=0.0;
        queue.offer(s);
        onQ[s]=true;
        while (!queue.isEmpty()&&!this.hasNegativeCycle()){
            int v=queue.poll();
            onQ[v]=false;
            relax(G,v);
        }
    }

    private void relax(EdgeWeightedDigraph G,int v){
        for(DirectedEdge e:G.adj2(v)){
            int w=e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w]=distTo[v]+e.weight();
                edgeTo[w]=e;
                if(!onQ[w]){
                    queue.offer(w);
                    onQ[w]=true;
                }
            }
            if(cost++%G.V()==0)
                findNegaticeCycle();
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

    private void findNegaticeCycle(){
        int V=edgeTo.length;
        EdgeWeightedDigraph spt;
        spt=new EdgeWeightedDigraph(V);
        for(int v=0;v<V;v++){
            if(edgeTo[v]!=null){
                spt.addEdge(edgeTo[v]);
            }
        }

        EdgeWeightedDirectedCycle cf;
        cf=new EdgeWeightedDirectedCycle(spt);
        cycle=cf.cycle();
    }

    public boolean hasNegativeCycle(){
        return cycle!=null;
    }

    public Iterable<DirectedEdge> negativeCycle(){
        return cycle;
    }

}


















