package lib;

/**
 * Created by earthgee on 2017/3/29.
 */
public class Edge implements Comparable<Edge>{

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v,int w,double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    double weight(){
        return weight;
    }

    int either(){
        return v;
    }

    int other(int vertex){
        if(vertex==v) return w;
        else if(vertex==w) return v;
        return -1;
    }


    @Override
    public int compareTo(Edge that) {
        if(this.weight()<that.weight()) return -1;
        else if(this.weight()>that.weight()) return 1;
        else
        return 0;
    }


}
